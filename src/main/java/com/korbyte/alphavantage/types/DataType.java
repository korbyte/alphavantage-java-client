package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DataType {
  JSON("json"),
  CSV("csv");

  private final String dataType;

  DataType(String dataType) {
    this.dataType = dataType;
  }

  @JsonValue
  @Override
  public String toString() {
    return dataType;
  }
}
