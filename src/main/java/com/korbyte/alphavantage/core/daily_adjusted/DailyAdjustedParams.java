package com.korbyte.alphavantage.core.daily_adjusted;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.OutputSize;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * AlphaVantage Daily Adjusted request params model
 */
@Data
public class DailyAdjustedParams {
  /**
   * By default, function=TIME_SERIES_DAILY_ADJUSTED.
   * Does not change
   */
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_DAILY_ADJUSTED;

  /**
   * The name of the equity of your choice.
   * For example, symbol=MSFT
   */
  private String symbol;

  /**
   * By default, outputsize=compact.
   */
  @JsonProperty(value = "outputsize")
  private OutputSize outputSize;
}
