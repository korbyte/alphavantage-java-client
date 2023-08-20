package com.korbyte.alphavantage.types.interval_models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum YearIntervalType {
  QUARTERLY("quarterly"),
  ANNUAL("annual");

  private final String intervalType;

  YearIntervalType(String intervalType) {
    this.intervalType = intervalType;
  }

  @JsonValue
  @Override
  public String toString() {
    return intervalType;
  }
}
