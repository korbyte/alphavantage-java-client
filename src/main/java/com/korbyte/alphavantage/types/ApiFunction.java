package com.korbyte.alphavantage.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ApiFunction {
  // Stock Time Series
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

  // Economic Indicators
  GDP("REAL_GDP"),
  GDP_PER_CAPITA("REAL_GDP_PER_CAPITA"),

  // Technical Indicators
  RSI("RSI");

  private final String function;

  ApiFunction(String function) {
    this.function = function;
  }

  /**
   * Deserialization: Convert a given string to the corresponding enum value
   *
   * @param value The string to convert
   */
  @JsonCreator
  public static ApiFunction fromString(String value) {
    for (ApiFunction os : ApiFunction.values()) {
      if (os.function.equalsIgnoreCase(value)) {
        return os;
      }
    }
    throw new IllegalArgumentException("Cannot deserialize value of type ApiFunction from string: " + value);
  }

  @JsonValue
  @Override
  public String toString() {
    return function;
  }
}
