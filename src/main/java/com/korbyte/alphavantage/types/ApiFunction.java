package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ApiFunction {
  TIME_SERIES_INTRADAY("TIME_SERIES_INTRADAY"),
  TIME_SERIES_DAILY("TIME_SERIES_DAILY"),
  TIME_SERIES_DAILY_ADJUSTED("TIME_SERIES_DAILY_ADJUSTED"),
  TIME_SERIES_WEEKLY("TIME_SERIES_WEEKLY"),
  TIME_SERIES_WEEKLY_ADJUSTED("TIME_SERIES_WEEKLY_ADJUSTED"),
  TIME_SERIES_MONTHLY("TIME_SERIES_MONTHLY"),
  TIME_SERIES_MONTHLY_ADJUSTED("TIME_SERIES_MONTHLY_ADJUSTED"),
  GLOBAL_QUOTE("GLOBAL_QUOTE"),
  SYMBOL_SEARCH("SYMBOL_SEARCH"),
  MARKET_STATUS("MARKET_STATUS"),
  COMPANY_OVERVIEW("OVERVIEW"),
  LISTING_STATUS("LISTING_STATUS"),
  GDP("REAL_GDP");

  private final String function;

  ApiFunction(String function) {
    this.function = function;
  }

  @JsonValue
  @Override
  public String toString() {
    return function;
  }
}
