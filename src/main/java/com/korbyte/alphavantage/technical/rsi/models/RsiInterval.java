package com.korbyte.alphavantage.technical.rsi.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RsiInterval {

  ONE_MIN("1min"),
  FIVE_MIN("5min"),
  FIFTEEN_MIN("15min"),
  THIRTY_MIN("30min"),
  SIXTY_MIN("60min"),
  DAILY("daily"),
  WEEKLY("weekly"),
  MONTHLY("monthly");

  private final String interval;

  RsiInterval(String intervalType) {
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
  public static RsiInterval fromString(String value) {
    for (RsiInterval os : RsiInterval.values()) {
      if (os.interval.equalsIgnoreCase(value)) {
        return os;
      }
    }
    throw new IllegalArgumentException("Cannot deserialize value of type RsiInterval from string: " + value);
  }
}
