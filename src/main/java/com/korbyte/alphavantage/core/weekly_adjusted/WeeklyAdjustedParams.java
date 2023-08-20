package com.korbyte.alphavantage.core.weekly_adjusted;

import com.korbyte.alphavantage.params.ApiFunction;
import com.korbyte.alphavantage.params.DataType;
import com.korbyte.alphavantage.params.OutputSize;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * AlphaVantage Daily Adjusted request params model
 */
@Data
public class WeeklyAdjustedParams {
  /**
   * By default, function=TIME_SERIES_DAILY_ADJUSTED.
   * Does not change
   */
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_WEEKLY_ADJUSTED;

  /**
   * The name of the equity of your choice.
   * For example, symbol=MSFT
   */
  private String symbol;

  /**
   * By default, outputsize=compact.
   */
  private OutputSize outputSize;
}
