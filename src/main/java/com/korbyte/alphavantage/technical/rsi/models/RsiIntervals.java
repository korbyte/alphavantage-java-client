package com.korbyte.alphavantage.technical.rsi.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RsiIntervals {
  DAILY("daily"),
  WEEKLY("weekly"),
  MONTHLY("monthly");

  private final String intervalType;

  IntervalType(String intervalType) {
    this.intervalType = intervalType;
  }

  @JsonValue
  @Override
  public String toString() {
    return intervalType;
  }
}
