package com.korbyte.alphavantage.types.interval_models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MinIntervalType {
  ONE_MIN("1min"),
  FIVE_MIN("5min"),
  FIFTEEN_MIN("15min"),
  THIRTY_MIN("30min"),
  SIXTY_MIN("60min");

  private final String interval;

  MinIntervalType(String interval) {
    this.interval = interval;
  }

  /**
   * Deserialization: Convert a given string to the corresponding enum value
   *
   * @param value The string to convert
   */
  @JsonCreator
  public static MinIntervalType fromString(String value) {
    for (MinIntervalType os : MinIntervalType.values()) {
      if (os.interval.equalsIgnoreCase(value)) {
        return os;
      }
    }
    throw new IllegalArgumentException("Cannot deserialize value of type MinIntervalType from string: " + value);
  }

  @JsonValue
  @Override
  public String toString() {
    return interval;
  }
}
