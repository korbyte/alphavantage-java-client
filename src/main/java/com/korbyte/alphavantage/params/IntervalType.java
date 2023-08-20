package com.korbyte.alphavantage.params;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IntervalType {
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
