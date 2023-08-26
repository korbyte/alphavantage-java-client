package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DataType {
  JSON("json"),
  CSV("csv");

  private final String dataType;

  DataType(String dataType) {
    this.dataType = dataType;
  }

  /**
   * Deserialization: Convert a given string to the corresponding enum value
   *
   * @param value The string to convert
   */
  @JsonCreator
  public static DataType fromString(String value) {
    for (DataType os : DataType.values()) {
      if (os.dataType.equalsIgnoreCase(value)) {
        return os;
      }
    }
    throw new IllegalArgumentException("Cannot deserialize value of type DataType from string: " + value);
  }

  @JsonValue
  @Override
  public String toString() {
    return dataType;
  }
}
