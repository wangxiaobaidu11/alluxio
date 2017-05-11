/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.master.file.meta;

import alluxio.AlluxioURI;
import alluxio.collections.ConcurrentHashSet;
import alluxio.exception.ExceptionMessage;
import alluxio.exception.InvalidPathException;
import alluxio.master.file.meta.options.MountInfo;
import alluxio.underfs.UnderFileSystem;
import alluxio.util.ThreadFactoryUtils;
import alluxio.util.io.PathUtils;

import io.netty.util.internal.chmv8.ConcurrentHashMapV8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.concurrent.ThreadSafe;

/**
 * This is a {@link UfsAbsentPathCache} which implements an asynchronous add to the cache, since
 * the processing of the path may be slow.
 */
@ThreadSafe
public final class UfsAbsentPathAsyncCache implements UfsAbsentPathCache {
  private static final Logger LOG = LoggerFactory.getLogger(UfsAbsentPathAsyncCache.class);
  /** Number of threads for the async pool. */
  private static final int NUM_THREADS = 50;
  /** Number of seconds to keep threads alive. */
  private static final int THREAD_KEEP_ALIVE_SECONDS = 60;

  /** The mount table. */
  private final MountTable mMountTable;
  /** Stores a cache for each mount point (the key is mount id). */
  private final ConcurrentHashMapV8<Long, ConcurrentSkipListSet<String>> mCaches;
  /** A set of paths currently being processed. This is used to prevent duplicate processing. */
  private final ConcurrentHashSet<String> mCurrentPaths;

  /** A thread pool for the async tasks. */
  private final ThreadPoolExecutor mPool;

  /**
   * Creates a new instance of {@link UfsAbsentPathAsyncCache}.
   *
   * @param mountTable the mount table
   */
  public UfsAbsentPathAsyncCache(MountTable mountTable) {
    mMountTable = mountTable;
    mCaches = new ConcurrentHashMapV8<>(8, 0.95f, 8);
    mCurrentPaths = new ConcurrentHashSet<>(8, 0.95f, 8);

    mPool = new ThreadPoolExecutor(NUM_THREADS, NUM_THREADS, THREAD_KEEP_ALIVE_SECONDS,
        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
        ThreadFactoryUtils.build("UFS-Absent-Path-Cache-%d", true));
  }

  @Override
  public void removeMountPoint(long mountId) {
    mCaches.remove(mountId);
  }

  @Override
  public void addAbsentPath(AlluxioURI path) {
    if (mCurrentPaths.contains(path.toString())) {
      // already being processed by another thread.
      return;
    }
    mPool.submit(new ProcessPathTask(path));
  }

  @Override
  public void removeAbsentPath(AlluxioURI path) throws InvalidPathException {
    MountTable.Resolution resolution = mMountTable.resolve(path);
    ConcurrentSkipListSet<String> cache = getCache(resolution.getMountId());
    String[] components = PathUtils.getPathComponents(resolution.getUri().getPath());

    MountInfo mountInfo = mMountTable.getMountInfo(resolution.getMountId());
    if (mountInfo == null) {
      return;
    }
    // create a ufs uri of the root of the mount point.
    AlluxioURI uri = mountInfo.getUfsUri();
    int mountPointBase = uri.getDepth();

    // Traverse through the ufs path components, starting from the mount point base.
    for (int i = 0; i < components.length; i++) {
      if (i > 0 && i <= mountPointBase) {
        // Do not process components before the base of the mount point.
        // However, process the first component, since that will be the actual mount point base.
        continue;
      }
      String component = components[i];
      uri = uri.join(component);
      String uriPath = uri.getPath();
      // This ufs path exists. Remove the cache entry.
      cache.remove(uriPath);
    }
  }

  @Override
  public boolean isAbsent(AlluxioURI path) throws InvalidPathException {
    MountTable.Resolution resolution = mMountTable.resolve(path);
    AlluxioURI ufsUri = resolution.getUri();
    ConcurrentSkipListSet<String> cache = getCache(resolution.getMountId());

    MountInfo mountInfo = mMountTable.getMountInfo(resolution.getMountId());
    if (mountInfo == null) {
      return false;
    }
    // create a ufs uri of the root of the mount point.
    AlluxioURI mountBaseUri = mountInfo.getUfsUri();

    while (ufsUri != null && !ufsUri.equals(mountBaseUri)) {
      if (cache.contains(ufsUri.getPath())) {
        return true;
      }
      ufsUri = ufsUri.getParent();
    }
    // Reached the root, without finding anything in the cache.
    return false;
  }

  /**
   * Returns the set representing the cache for the given mount id.
   *
   * @param mountId the mount id to get the cache for
   * @return the cache for the mount id
   */
  private ConcurrentSkipListSet<String> getCache(long mountId) {
    ConcurrentSkipListSet<String> set = mCaches.get(mountId);
    if (set != null) {
      return set;
    }

    set = new ConcurrentSkipListSet<>();
    ConcurrentSkipListSet<String> existing = mCaches.putIfAbsent(mountId, set);
    if (existing != null) {
      return existing;
    }
    return set;
  }

  /**
   * Adds the given absent path into the cache synchronously. This will sequentially walk down
   * the path to find the first component which does not exist in the ufs.
   *
   * @param path the absent path to add to the cache
   * @throws InvalidPathException if the path is invalid
   */
  private void syncAddAbsentPath(AlluxioURI path) throws InvalidPathException {
    MountTable.Resolution resolution = mMountTable.resolve(path);
    UnderFileSystem ufs = resolution.getUfs();
    ConcurrentSkipListSet<String> cache = getCache(resolution.getMountId());
    String[] components = PathUtils.getPathComponents(resolution.getUri().getPath());

    MountInfo mountInfo = mMountTable.getMountInfo(resolution.getMountId());
    if (mountInfo == null) {
      return;
    }
    // create a ufs uri of the root of the mount point.
    AlluxioURI uri = mountInfo.getUfsUri();
    int mountPointBase = uri.getDepth();

    // Traverse through the ufs path components, starting from the mount point base, to find the
    // first non-existing ufs path.
    for (int i = 0; i < components.length; i++) {
      if (i > 0 && i <= mountPointBase) {
        // Do not process components before the base of the mount point.
        // However, process the first component, since that will be the actual mount point base.
        continue;
      }
      String component = components[i];
      uri = uri.join(component);
      String uriPath = uri.getPath();
      try {
        if (ufs.exists(uri.toString())) {
          // This ufs path exists. Remove the cache entry.
          cache.remove(uriPath);
        } else {
          // This is the first ufs path which does not exist. Add it to the cache.
          cache.add(uriPath);

          // Remove cache entries which has this non-existing directory as a prefix. This is not for
          // correctness, but to "compress" information. Iterate (in order) starting from this
          // absent directory.
          String dirPath = uriPath + "/";
          Iterator<String> it = cache.tailSet(dirPath).iterator();
          while (it.hasNext()) {
            String existingPath = it.next();
            if (existingPath.startsWith(dirPath)) {
              // An existing cache entry has the non-existing path as a prefix. Remove the entry,
              // since the non-existing path ancestor implies the descendant does not exist.
              it.remove();
            } else {
              // Stop the iteration when it reaches the first entry which does not have this
              // absent directory as the prefix.
              break;
            }
          }
          // The first non-existing path was found, so further traversal is unnecessary.
          break;
        }
      } catch (IOException e) {
        throw new InvalidPathException(ExceptionMessage.PATH_DOES_NOT_EXIST.getMessage(path), e);
      }
    }
  }

  /**
   * This is the async task for adding a path to the cache.
   */
  private final class ProcessPathTask implements Runnable {
    private final AlluxioURI mPath;

    /**
     * @param path the path to add
     */
    private ProcessPathTask(AlluxioURI path) {
      mPath = path;
    }

    @Override
    public void run() {
      if (!mCurrentPaths.addIfAbsent(mPath.toString())) {
        // already being processed by another thread.
        return;
      }
      try {
        syncAddAbsentPath(mPath);
      } catch (InvalidPathException e) {
        // Ignore the exception
        LOG.warn("Adding absent path failed: " + mPath, e);
      } finally {
        mCurrentPaths.remove(mPath.toString());
      }
    }
  }
}
