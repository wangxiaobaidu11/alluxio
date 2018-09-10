// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file_system_master.proto

package alluxio.grpc;

/**
 * Protobuf type {@code alluxio.grpc.CreateFilePOptions}
 */
public  final class CreateFilePOptions extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:alluxio.grpc.CreateFilePOptions)
    CreateFilePOptionsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateFilePOptions.newBuilder() to construct.
  private CreateFilePOptions(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateFilePOptions() {
    blockSizeBytes_ = 0L;
    persisted_ = false;
    recursive_ = false;
    mode_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateFilePOptions(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            bitField0_ |= 0x00000001;
            blockSizeBytes_ = input.readInt64();
            break;
          }
          case 16: {
            bitField0_ |= 0x00000002;
            persisted_ = input.readBool();
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            recursive_ = input.readBool();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            mode_ = input.readInt32();
            break;
          }
          case 42: {
            alluxio.grpc.FileSystemMasterCommonPOptions.Builder subBuilder = null;
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
              subBuilder = commonOptions_.toBuilder();
            }
            commonOptions_ = input.readMessage(alluxio.grpc.FileSystemMasterCommonPOptions.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(commonOptions_);
              commonOptions_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000010;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return alluxio.grpc.FileSystemMasterProto.internal_static_alluxio_grpc_CreateFilePOptions_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return alluxio.grpc.FileSystemMasterProto.internal_static_alluxio_grpc_CreateFilePOptions_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            alluxio.grpc.CreateFilePOptions.class, alluxio.grpc.CreateFilePOptions.Builder.class);
  }

  private int bitField0_;
  public static final int BLOCKSIZEBYTES_FIELD_NUMBER = 1;
  private long blockSizeBytes_;
  /**
   * <code>optional int64 blockSizeBytes = 1;</code>
   */
  public boolean hasBlockSizeBytes() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional int64 blockSizeBytes = 1;</code>
   */
  public long getBlockSizeBytes() {
    return blockSizeBytes_;
  }

  public static final int PERSISTED_FIELD_NUMBER = 2;
  private boolean persisted_;
  /**
   * <code>optional bool persisted = 2;</code>
   */
  public boolean hasPersisted() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional bool persisted = 2;</code>
   */
  public boolean getPersisted() {
    return persisted_;
  }

  public static final int RECURSIVE_FIELD_NUMBER = 3;
  private boolean recursive_;
  /**
   * <code>optional bool recursive = 3;</code>
   */
  public boolean hasRecursive() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional bool recursive = 3;</code>
   */
  public boolean getRecursive() {
    return recursive_;
  }

  public static final int MODE_FIELD_NUMBER = 4;
  private int mode_;
  /**
   * <code>optional int32 mode = 4;</code>
   */
  public boolean hasMode() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional int32 mode = 4;</code>
   */
  public int getMode() {
    return mode_;
  }

  public static final int COMMONOPTIONS_FIELD_NUMBER = 5;
  private alluxio.grpc.FileSystemMasterCommonPOptions commonOptions_;
  /**
   * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
   */
  public boolean hasCommonOptions() {
    return ((bitField0_ & 0x00000010) == 0x00000010);
  }
  /**
   * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
   */
  public alluxio.grpc.FileSystemMasterCommonPOptions getCommonOptions() {
    return commonOptions_ == null ? alluxio.grpc.FileSystemMasterCommonPOptions.getDefaultInstance() : commonOptions_;
  }
  /**
   * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
   */
  public alluxio.grpc.FileSystemMasterCommonPOptionsOrBuilder getCommonOptionsOrBuilder() {
    return commonOptions_ == null ? alluxio.grpc.FileSystemMasterCommonPOptions.getDefaultInstance() : commonOptions_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeInt64(1, blockSizeBytes_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeBool(2, persisted_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeBool(3, recursive_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeInt32(4, mode_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      output.writeMessage(5, getCommonOptions());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, blockSizeBytes_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, persisted_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, recursive_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, mode_);
    }
    if (((bitField0_ & 0x00000010) == 0x00000010)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getCommonOptions());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof alluxio.grpc.CreateFilePOptions)) {
      return super.equals(obj);
    }
    alluxio.grpc.CreateFilePOptions other = (alluxio.grpc.CreateFilePOptions) obj;

    boolean result = true;
    result = result && (hasBlockSizeBytes() == other.hasBlockSizeBytes());
    if (hasBlockSizeBytes()) {
      result = result && (getBlockSizeBytes()
          == other.getBlockSizeBytes());
    }
    result = result && (hasPersisted() == other.hasPersisted());
    if (hasPersisted()) {
      result = result && (getPersisted()
          == other.getPersisted());
    }
    result = result && (hasRecursive() == other.hasRecursive());
    if (hasRecursive()) {
      result = result && (getRecursive()
          == other.getRecursive());
    }
    result = result && (hasMode() == other.hasMode());
    if (hasMode()) {
      result = result && (getMode()
          == other.getMode());
    }
    result = result && (hasCommonOptions() == other.hasCommonOptions());
    if (hasCommonOptions()) {
      result = result && getCommonOptions()
          .equals(other.getCommonOptions());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasBlockSizeBytes()) {
      hash = (37 * hash) + BLOCKSIZEBYTES_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getBlockSizeBytes());
    }
    if (hasPersisted()) {
      hash = (37 * hash) + PERSISTED_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getPersisted());
    }
    if (hasRecursive()) {
      hash = (37 * hash) + RECURSIVE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getRecursive());
    }
    if (hasMode()) {
      hash = (37 * hash) + MODE_FIELD_NUMBER;
      hash = (53 * hash) + getMode();
    }
    if (hasCommonOptions()) {
      hash = (37 * hash) + COMMONOPTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getCommonOptions().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static alluxio.grpc.CreateFilePOptions parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.CreateFilePOptions parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static alluxio.grpc.CreateFilePOptions parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static alluxio.grpc.CreateFilePOptions parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(alluxio.grpc.CreateFilePOptions prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code alluxio.grpc.CreateFilePOptions}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:alluxio.grpc.CreateFilePOptions)
      alluxio.grpc.CreateFilePOptionsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return alluxio.grpc.FileSystemMasterProto.internal_static_alluxio_grpc_CreateFilePOptions_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return alluxio.grpc.FileSystemMasterProto.internal_static_alluxio_grpc_CreateFilePOptions_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              alluxio.grpc.CreateFilePOptions.class, alluxio.grpc.CreateFilePOptions.Builder.class);
    }

    // Construct using alluxio.grpc.CreateFilePOptions.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getCommonOptionsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      blockSizeBytes_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      persisted_ = false;
      bitField0_ = (bitField0_ & ~0x00000002);
      recursive_ = false;
      bitField0_ = (bitField0_ & ~0x00000004);
      mode_ = 0;
      bitField0_ = (bitField0_ & ~0x00000008);
      if (commonOptionsBuilder_ == null) {
        commonOptions_ = null;
      } else {
        commonOptionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return alluxio.grpc.FileSystemMasterProto.internal_static_alluxio_grpc_CreateFilePOptions_descriptor;
    }

    public alluxio.grpc.CreateFilePOptions getDefaultInstanceForType() {
      return alluxio.grpc.CreateFilePOptions.getDefaultInstance();
    }

    public alluxio.grpc.CreateFilePOptions build() {
      alluxio.grpc.CreateFilePOptions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public alluxio.grpc.CreateFilePOptions buildPartial() {
      alluxio.grpc.CreateFilePOptions result = new alluxio.grpc.CreateFilePOptions(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.blockSizeBytes_ = blockSizeBytes_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.persisted_ = persisted_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.recursive_ = recursive_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.mode_ = mode_;
      if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
        to_bitField0_ |= 0x00000010;
      }
      if (commonOptionsBuilder_ == null) {
        result.commonOptions_ = commonOptions_;
      } else {
        result.commonOptions_ = commonOptionsBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof alluxio.grpc.CreateFilePOptions) {
        return mergeFrom((alluxio.grpc.CreateFilePOptions)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(alluxio.grpc.CreateFilePOptions other) {
      if (other == alluxio.grpc.CreateFilePOptions.getDefaultInstance()) return this;
      if (other.hasBlockSizeBytes()) {
        setBlockSizeBytes(other.getBlockSizeBytes());
      }
      if (other.hasPersisted()) {
        setPersisted(other.getPersisted());
      }
      if (other.hasRecursive()) {
        setRecursive(other.getRecursive());
      }
      if (other.hasMode()) {
        setMode(other.getMode());
      }
      if (other.hasCommonOptions()) {
        mergeCommonOptions(other.getCommonOptions());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      alluxio.grpc.CreateFilePOptions parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (alluxio.grpc.CreateFilePOptions) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long blockSizeBytes_ ;
    /**
     * <code>optional int64 blockSizeBytes = 1;</code>
     */
    public boolean hasBlockSizeBytes() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int64 blockSizeBytes = 1;</code>
     */
    public long getBlockSizeBytes() {
      return blockSizeBytes_;
    }
    /**
     * <code>optional int64 blockSizeBytes = 1;</code>
     */
    public Builder setBlockSizeBytes(long value) {
      bitField0_ |= 0x00000001;
      blockSizeBytes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 blockSizeBytes = 1;</code>
     */
    public Builder clearBlockSizeBytes() {
      bitField0_ = (bitField0_ & ~0x00000001);
      blockSizeBytes_ = 0L;
      onChanged();
      return this;
    }

    private boolean persisted_ ;
    /**
     * <code>optional bool persisted = 2;</code>
     */
    public boolean hasPersisted() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional bool persisted = 2;</code>
     */
    public boolean getPersisted() {
      return persisted_;
    }
    /**
     * <code>optional bool persisted = 2;</code>
     */
    public Builder setPersisted(boolean value) {
      bitField0_ |= 0x00000002;
      persisted_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool persisted = 2;</code>
     */
    public Builder clearPersisted() {
      bitField0_ = (bitField0_ & ~0x00000002);
      persisted_ = false;
      onChanged();
      return this;
    }

    private boolean recursive_ ;
    /**
     * <code>optional bool recursive = 3;</code>
     */
    public boolean hasRecursive() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional bool recursive = 3;</code>
     */
    public boolean getRecursive() {
      return recursive_;
    }
    /**
     * <code>optional bool recursive = 3;</code>
     */
    public Builder setRecursive(boolean value) {
      bitField0_ |= 0x00000004;
      recursive_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional bool recursive = 3;</code>
     */
    public Builder clearRecursive() {
      bitField0_ = (bitField0_ & ~0x00000004);
      recursive_ = false;
      onChanged();
      return this;
    }

    private int mode_ ;
    /**
     * <code>optional int32 mode = 4;</code>
     */
    public boolean hasMode() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 mode = 4;</code>
     */
    public int getMode() {
      return mode_;
    }
    /**
     * <code>optional int32 mode = 4;</code>
     */
    public Builder setMode(int value) {
      bitField0_ |= 0x00000008;
      mode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 mode = 4;</code>
     */
    public Builder clearMode() {
      bitField0_ = (bitField0_ & ~0x00000008);
      mode_ = 0;
      onChanged();
      return this;
    }

    private alluxio.grpc.FileSystemMasterCommonPOptions commonOptions_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        alluxio.grpc.FileSystemMasterCommonPOptions, alluxio.grpc.FileSystemMasterCommonPOptions.Builder, alluxio.grpc.FileSystemMasterCommonPOptionsOrBuilder> commonOptionsBuilder_;
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public boolean hasCommonOptions() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public alluxio.grpc.FileSystemMasterCommonPOptions getCommonOptions() {
      if (commonOptionsBuilder_ == null) {
        return commonOptions_ == null ? alluxio.grpc.FileSystemMasterCommonPOptions.getDefaultInstance() : commonOptions_;
      } else {
        return commonOptionsBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public Builder setCommonOptions(alluxio.grpc.FileSystemMasterCommonPOptions value) {
      if (commonOptionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        commonOptions_ = value;
        onChanged();
      } else {
        commonOptionsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public Builder setCommonOptions(
        alluxio.grpc.FileSystemMasterCommonPOptions.Builder builderForValue) {
      if (commonOptionsBuilder_ == null) {
        commonOptions_ = builderForValue.build();
        onChanged();
      } else {
        commonOptionsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public Builder mergeCommonOptions(alluxio.grpc.FileSystemMasterCommonPOptions value) {
      if (commonOptionsBuilder_ == null) {
        if (((bitField0_ & 0x00000010) == 0x00000010) &&
            commonOptions_ != null &&
            commonOptions_ != alluxio.grpc.FileSystemMasterCommonPOptions.getDefaultInstance()) {
          commonOptions_ =
            alluxio.grpc.FileSystemMasterCommonPOptions.newBuilder(commonOptions_).mergeFrom(value).buildPartial();
        } else {
          commonOptions_ = value;
        }
        onChanged();
      } else {
        commonOptionsBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000010;
      return this;
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public Builder clearCommonOptions() {
      if (commonOptionsBuilder_ == null) {
        commonOptions_ = null;
        onChanged();
      } else {
        commonOptionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public alluxio.grpc.FileSystemMasterCommonPOptions.Builder getCommonOptionsBuilder() {
      bitField0_ |= 0x00000010;
      onChanged();
      return getCommonOptionsFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    public alluxio.grpc.FileSystemMasterCommonPOptionsOrBuilder getCommonOptionsOrBuilder() {
      if (commonOptionsBuilder_ != null) {
        return commonOptionsBuilder_.getMessageOrBuilder();
      } else {
        return commonOptions_ == null ?
            alluxio.grpc.FileSystemMasterCommonPOptions.getDefaultInstance() : commonOptions_;
      }
    }
    /**
     * <code>optional .alluxio.grpc.FileSystemMasterCommonPOptions commonOptions = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        alluxio.grpc.FileSystemMasterCommonPOptions, alluxio.grpc.FileSystemMasterCommonPOptions.Builder, alluxio.grpc.FileSystemMasterCommonPOptionsOrBuilder> 
        getCommonOptionsFieldBuilder() {
      if (commonOptionsBuilder_ == null) {
        commonOptionsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            alluxio.grpc.FileSystemMasterCommonPOptions, alluxio.grpc.FileSystemMasterCommonPOptions.Builder, alluxio.grpc.FileSystemMasterCommonPOptionsOrBuilder>(
                getCommonOptions(),
                getParentForChildren(),
                isClean());
        commonOptions_ = null;
      }
      return commonOptionsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:alluxio.grpc.CreateFilePOptions)
  }

  // @@protoc_insertion_point(class_scope:alluxio.grpc.CreateFilePOptions)
  private static final alluxio.grpc.CreateFilePOptions DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new alluxio.grpc.CreateFilePOptions();
  }

  public static alluxio.grpc.CreateFilePOptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<CreateFilePOptions>
      PARSER = new com.google.protobuf.AbstractParser<CreateFilePOptions>() {
    public CreateFilePOptions parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CreateFilePOptions(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateFilePOptions> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateFilePOptions> getParserForType() {
    return PARSER;
  }

  public alluxio.grpc.CreateFilePOptions getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

