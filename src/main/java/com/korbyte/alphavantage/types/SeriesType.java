package com.korbyte.alphavantage.types;

public enum SeriesType {
  OPEN("open"),
  HIGH("high"),
  LOW("low"),
  CLOSE("close");

  private final String seriesType;

  SeriesType(String seriesType) {
    this.seriesType = seriesType;
  }

  @Override
  public String toString() {
    return seriesType;
  }
}
