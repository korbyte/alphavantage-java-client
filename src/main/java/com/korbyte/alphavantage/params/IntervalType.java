package com.korbyte.alphavantage.params;

enum IntervalType {
  ONE_MIN("1min"),
  FIVE_MIN("5min"),
  FIFTEEN_MIN("15min"),
  THIRTY_MIN("30min"),
  SIXTY_MIN("60min");

  private final String interval;

  IntervalType(String interval) {
    this.interval = interval;
  }

  @Override
  public String toString() {
    return interval;
  }
}
