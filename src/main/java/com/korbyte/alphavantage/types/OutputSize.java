package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OutputSize {
  COMPACT("compact"),
  FULL("full");

  private final String outputsize;

  OutputSize(String outputsize) {
    this.outputsize = outputsize;
  }

  @JsonValue
  @Override
  public String toString() {
    return outputsize;
  }
}
