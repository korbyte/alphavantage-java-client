package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OutputSize {
  COMPACT("compact"),
  FULL("full");

  private final String outputSize;

  OutputSize(String outputSize) {
    this.outputSize = outputSize;
  }

  /**
   * Deserialization: Convert a given string to the corresponding enum value
   *
   * @param value The string to convert
   */
  @JsonCreator
  public static OutputSize fromString(String value) {
    value = value.toLowerCase();
    if (value.contains("compact")) {
      return COMPACT;
    } else if (value.contains("full")) {
      return FULL;
    } else {
      throw new IllegalArgumentException("Cannot deserialize value of type OutputSize from string: " + value);
    }
  }

  @JsonValue
  @Override
  public String toString() {
    return outputSize;
  }
}
