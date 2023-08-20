package com.korbyte.alphavantage.params;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MinIntervalType {
  ONE_MIN("1min"),
  FIVE_MIN("5min"),
  FIFTEEN_MIN("15min"),
  THIRTY_MIN("30min"),
  SIXTY_MIN("60min");

  private final String interval;

  MinIntervalType(String interval) {
    this.interval = interval;
  }

  @JsonValue
  @Override
  public String toString() {
    return interval;
  }
}
