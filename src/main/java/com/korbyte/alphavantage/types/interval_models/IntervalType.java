package com.korbyte.alphavantage.types.interval_models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IntervalType {
  DAILY("daily"),
  WEEKLY("weekly"),
  MONTHLY("monthly");

  private final String interval;

  IntervalType(String intervalType) {
    this.interval = intervalType;
  }

  @JsonValue
  @Override
  public String toString() {
    return interval;
  }

  /**
   * Deserialization: Convert a given string to the corresponding enum value
   * @param value The string to convert
   */
  @JsonCreator
  public static IntervalType fromString(String value) {
    for (IntervalType os : IntervalType.values()) {
      if (os.interval.equalsIgnoreCase(value)) {
        return os;
      }
    }
    throw new IllegalArgumentException("Cannot deserialize value of type IntervalType from string: " + value);
  }
}
