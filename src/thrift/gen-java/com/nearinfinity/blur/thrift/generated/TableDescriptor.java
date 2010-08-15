/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.nearinfinity.blur.thrift.generated;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class TableDescriptor implements TBase<TableDescriptor, TableDescriptor._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("TableDescriptor");

  private static final TField ANALYZER_DEF_FIELD_DESC = new TField("analyzerDef", TType.STRING, (short)1);
  private static final TField PARTITIONER_CLASS_FIELD_DESC = new TField("partitionerClass", TType.STRING, (short)2);
  private static final TField SHARD_DIRECTORY_LOCATION_FIELD_DESC = new TField("shardDirectoryLocation", TType.MAP, (short)3);

  public String analyzerDef;
  public String partitionerClass;
  public Map<String,String> shardDirectoryLocation;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    ANALYZER_DEF((short)1, "analyzerDef"),
    PARTITIONER_CLASS((short)2, "partitionerClass"),
    SHARD_DIRECTORY_LOCATION((short)3, "shardDirectoryLocation");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ANALYZER_DEF
          return ANALYZER_DEF;
        case 2: // PARTITIONER_CLASS
          return PARTITIONER_CLASS;
        case 3: // SHARD_DIRECTORY_LOCATION
          return SHARD_DIRECTORY_LOCATION;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ANALYZER_DEF, new FieldMetaData("analyzerDef", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.PARTITIONER_CLASS, new FieldMetaData("partitionerClass", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.SHARD_DIRECTORY_LOCATION, new FieldMetaData("shardDirectoryLocation", TFieldRequirementType.DEFAULT, 
        new MapMetaData(TType.MAP, 
            new FieldValueMetaData(TType.STRING), 
            new FieldValueMetaData(TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(TableDescriptor.class, metaDataMap);
  }

  public TableDescriptor() {
  }

  public TableDescriptor(
    String analyzerDef,
    String partitionerClass,
    Map<String,String> shardDirectoryLocation)
  {
    this();
    this.analyzerDef = analyzerDef;
    this.partitionerClass = partitionerClass;
    this.shardDirectoryLocation = shardDirectoryLocation;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TableDescriptor(TableDescriptor other) {
    if (other.isSetAnalyzerDef()) {
      this.analyzerDef = other.analyzerDef;
    }
    if (other.isSetPartitionerClass()) {
      this.partitionerClass = other.partitionerClass;
    }
    if (other.isSetShardDirectoryLocation()) {
      Map<String,String> __this__shardDirectoryLocation = new HashMap<String,String>();
      for (Map.Entry<String, String> other_element : other.shardDirectoryLocation.entrySet()) {

        String other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        String __this__shardDirectoryLocation_copy_key = other_element_key;

        String __this__shardDirectoryLocation_copy_value = other_element_value;

        __this__shardDirectoryLocation.put(__this__shardDirectoryLocation_copy_key, __this__shardDirectoryLocation_copy_value);
      }
      this.shardDirectoryLocation = __this__shardDirectoryLocation;
    }
  }

  public TableDescriptor deepCopy() {
    return new TableDescriptor(this);
  }

  @Deprecated
  public TableDescriptor clone() {
    return new TableDescriptor(this);
  }

  public String getAnalyzerDef() {
    return this.analyzerDef;
  }

  public TableDescriptor setAnalyzerDef(String analyzerDef) {
    this.analyzerDef = analyzerDef;
    return this;
  }

  public void unsetAnalyzerDef() {
    this.analyzerDef = null;
  }

  /** Returns true if field analyzerDef is set (has been asigned a value) and false otherwise */
  public boolean isSetAnalyzerDef() {
    return this.analyzerDef != null;
  }

  public void setAnalyzerDefIsSet(boolean value) {
    if (!value) {
      this.analyzerDef = null;
    }
  }

  public String getPartitionerClass() {
    return this.partitionerClass;
  }

  public TableDescriptor setPartitionerClass(String partitionerClass) {
    this.partitionerClass = partitionerClass;
    return this;
  }

  public void unsetPartitionerClass() {
    this.partitionerClass = null;
  }

  /** Returns true if field partitionerClass is set (has been asigned a value) and false otherwise */
  public boolean isSetPartitionerClass() {
    return this.partitionerClass != null;
  }

  public void setPartitionerClassIsSet(boolean value) {
    if (!value) {
      this.partitionerClass = null;
    }
  }

  public int getShardDirectoryLocationSize() {
    return (this.shardDirectoryLocation == null) ? 0 : this.shardDirectoryLocation.size();
  }

  public void putToShardDirectoryLocation(String key, String val) {
    if (this.shardDirectoryLocation == null) {
      this.shardDirectoryLocation = new HashMap<String,String>();
    }
    this.shardDirectoryLocation.put(key, val);
  }

  public Map<String,String> getShardDirectoryLocation() {
    return this.shardDirectoryLocation;
  }

  public TableDescriptor setShardDirectoryLocation(Map<String,String> shardDirectoryLocation) {
    this.shardDirectoryLocation = shardDirectoryLocation;
    return this;
  }

  public void unsetShardDirectoryLocation() {
    this.shardDirectoryLocation = null;
  }

  /** Returns true if field shardDirectoryLocation is set (has been asigned a value) and false otherwise */
  public boolean isSetShardDirectoryLocation() {
    return this.shardDirectoryLocation != null;
  }

  public void setShardDirectoryLocationIsSet(boolean value) {
    if (!value) {
      this.shardDirectoryLocation = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ANALYZER_DEF:
      if (value == null) {
        unsetAnalyzerDef();
      } else {
        setAnalyzerDef((String)value);
      }
      break;

    case PARTITIONER_CLASS:
      if (value == null) {
        unsetPartitionerClass();
      } else {
        setPartitionerClass((String)value);
      }
      break;

    case SHARD_DIRECTORY_LOCATION:
      if (value == null) {
        unsetShardDirectoryLocation();
      } else {
        setShardDirectoryLocation((Map<String,String>)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ANALYZER_DEF:
      return getAnalyzerDef();

    case PARTITIONER_CLASS:
      return getPartitionerClass();

    case SHARD_DIRECTORY_LOCATION:
      return getShardDirectoryLocation();

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case ANALYZER_DEF:
      return isSetAnalyzerDef();
    case PARTITIONER_CLASS:
      return isSetPartitionerClass();
    case SHARD_DIRECTORY_LOCATION:
      return isSetShardDirectoryLocation();
    }
    throw new IllegalStateException();
  }

  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TableDescriptor)
      return this.equals((TableDescriptor)that);
    return false;
  }

  public boolean equals(TableDescriptor that) {
    if (that == null)
      return false;

    boolean this_present_analyzerDef = true && this.isSetAnalyzerDef();
    boolean that_present_analyzerDef = true && that.isSetAnalyzerDef();
    if (this_present_analyzerDef || that_present_analyzerDef) {
      if (!(this_present_analyzerDef && that_present_analyzerDef))
        return false;
      if (!this.analyzerDef.equals(that.analyzerDef))
        return false;
    }

    boolean this_present_partitionerClass = true && this.isSetPartitionerClass();
    boolean that_present_partitionerClass = true && that.isSetPartitionerClass();
    if (this_present_partitionerClass || that_present_partitionerClass) {
      if (!(this_present_partitionerClass && that_present_partitionerClass))
        return false;
      if (!this.partitionerClass.equals(that.partitionerClass))
        return false;
    }

    boolean this_present_shardDirectoryLocation = true && this.isSetShardDirectoryLocation();
    boolean that_present_shardDirectoryLocation = true && that.isSetShardDirectoryLocation();
    if (this_present_shardDirectoryLocation || that_present_shardDirectoryLocation) {
      if (!(this_present_shardDirectoryLocation && that_present_shardDirectoryLocation))
        return false;
      if (!this.shardDirectoryLocation.equals(that.shardDirectoryLocation))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TableDescriptor other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TableDescriptor typedOther = (TableDescriptor)other;

    lastComparison = Boolean.valueOf(isSetAnalyzerDef()).compareTo(typedOther.isSetAnalyzerDef());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAnalyzerDef()) {      lastComparison = TBaseHelper.compareTo(this.analyzerDef, typedOther.analyzerDef);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPartitionerClass()).compareTo(typedOther.isSetPartitionerClass());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPartitionerClass()) {      lastComparison = TBaseHelper.compareTo(this.partitionerClass, typedOther.partitionerClass);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetShardDirectoryLocation()).compareTo(typedOther.isSetShardDirectoryLocation());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetShardDirectoryLocation()) {      lastComparison = TBaseHelper.compareTo(this.shardDirectoryLocation, typedOther.shardDirectoryLocation);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // ANALYZER_DEF
          if (field.type == TType.STRING) {
            this.analyzerDef = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PARTITIONER_CLASS
          if (field.type == TType.STRING) {
            this.partitionerClass = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // SHARD_DIRECTORY_LOCATION
          if (field.type == TType.MAP) {
            {
              TMap _map9 = iprot.readMapBegin();
              this.shardDirectoryLocation = new HashMap<String,String>(2*_map9.size);
              for (int _i10 = 0; _i10 < _map9.size; ++_i10)
              {
                String _key11;
                String _val12;
                _key11 = iprot.readString();
                _val12 = iprot.readString();
                this.shardDirectoryLocation.put(_key11, _val12);
              }
              iprot.readMapEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.analyzerDef != null) {
      oprot.writeFieldBegin(ANALYZER_DEF_FIELD_DESC);
      oprot.writeString(this.analyzerDef);
      oprot.writeFieldEnd();
    }
    if (this.partitionerClass != null) {
      oprot.writeFieldBegin(PARTITIONER_CLASS_FIELD_DESC);
      oprot.writeString(this.partitionerClass);
      oprot.writeFieldEnd();
    }
    if (this.shardDirectoryLocation != null) {
      oprot.writeFieldBegin(SHARD_DIRECTORY_LOCATION_FIELD_DESC);
      {
        oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, this.shardDirectoryLocation.size()));
        for (Map.Entry<String, String> _iter13 : this.shardDirectoryLocation.entrySet())
        {
          oprot.writeString(_iter13.getKey());
          oprot.writeString(_iter13.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TableDescriptor(");
    boolean first = true;

    sb.append("analyzerDef:");
    if (this.analyzerDef == null) {
      sb.append("null");
    } else {
      sb.append(this.analyzerDef);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("partitionerClass:");
    if (this.partitionerClass == null) {
      sb.append("null");
    } else {
      sb.append(this.partitionerClass);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("shardDirectoryLocation:");
    if (this.shardDirectoryLocation == null) {
      sb.append("null");
    } else {
      sb.append(this.shardDirectoryLocation);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}
