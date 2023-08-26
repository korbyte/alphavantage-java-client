package com.korbyte.alphavantage.types.interval_models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum YearIntervalType {
  QUARTERLY("quarterly"),
  ANNUAL("annual");

  private final String interval;

  YearIntervalType(String intervalType) {
    this.interval = intervalType;
  }

  /**
   * Deserialization: Convert a given string to the corresponding enum value
   *
   * @param value The string to convert
   */
  @JsonCreator
  public static YearIntervalType fromString(String value) {
    for (YearIntervalType os : YearIntervalType.values()) {
      if (os.interval.equalsIgnoreCase(value)) {
        return os;
      }
    }
    throw new IllegalArgumentException("Cannot deserialize value of type YearIntervalType from string: " + value);
  }

  @JsonValue
  @Override
  public String toString() {
    return interval;
  }
}
