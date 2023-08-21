package com.korbyte.alphavantage.technical.rsi.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RsiIntervals {

  ONE_MIN("1min"),
  FIVE_MIN("5min"),
  FIFTEEN_MIN("15min"),
  THIRTY_MIN("30min"),
  SIXTY_MIN("60min"),
  DAILY("daily"),
  WEEKLY("weekly"),
  MONTHLY("monthly");

  private final String intervalType;

  RsiIntervals(String intervalType) {
    this.intervalType = intervalType;
  }

  @JsonValue
  @Override
  public String toString() {
    return intervalType;
  }
}
