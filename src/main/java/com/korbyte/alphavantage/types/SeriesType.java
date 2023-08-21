package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonValue;

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
}
