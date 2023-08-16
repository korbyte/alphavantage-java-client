package com.korbyte.alphavantage.base;

public enum ApiFunction {

  DAILY("TIME_SERIES_DAILY"),
  DAILY_ADJUSTED("TIME_SERIES_DAILY_ADJUSTED"),
  WEEKLY("TIME_SERIES_WEEKLY"),
  WEEKLY_ADJUSTED("TIME_SERIES_WEEKLY_ADJUSTED"),
  MONTHLY("TIME_SERIES_MONTHLY"),
  MONTHLY_ADJUSTED("TIME_SERIES_MONTHLY_ADJUSTED"),
  INTRADAY("TIME_SERIES_INTRADAY"),
  GLOBAL_QUOTE("GLOBAL_QUOTE"),
  SYMBOL_SEARCH("SYMBOL_SEARCH"),
  MARKET_STATUS("MARKET_STATUS"),
  LISTING_STATUS("LISTING_STATUS");

  private final String function;

  ApiFunction(String function) {
    this.function = function;
  }

  @Override
  public String toString() {
    return this.function;
  }
}
