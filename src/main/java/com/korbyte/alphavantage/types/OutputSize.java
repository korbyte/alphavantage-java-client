package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OutputSize {
  COMPACT("compact"),
  FULL("full");

  private final String outputSize;

  OutputSize(String outputSize) {
    this.outputSize = outputSize;
  }

  @JsonValue
  @Override
  public String toString() {
    return outputSize;
  }
}
