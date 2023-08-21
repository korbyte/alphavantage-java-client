package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Representation of the series type for the technical indicators API from alphavantage.co
 */
public enum SeriesType {
  OPEN("open"),
  HIGH("high"),
  LOW("low"),
  CLOSE("close");

  private final String seriesType;

  SeriesType(String seriesType) {
    this.seriesType = seriesType;
  }

  @JsonValue
  @Override
  public String toString() {
    return seriesType;
  }

  /**
   * Deserialization: Convert a given string to the corresponding enum value
   * @param value The string to convert
   */
  @JsonCreator
  public static SeriesType fromString(String value) {
    for (SeriesType os : SeriesType.values()) {
      if (os.seriesType.equalsIgnoreCase(value)) {
        return os;
      }
    }
    throw new IllegalArgumentException("Cannot deserialize value of type SeriesType from string: " + value);
  }
}
