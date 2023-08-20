package com.korbyte.alphavantage.core.daily;

import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.OutputSize;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * AlphaVantage Daily request params model
 */
@Data
public class DailyParams {
  /**
   * By default, function=TIME_SERIES_DAILY.
   * Does not change
   */
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_DAILY;

  /**
   * The name of the equity of your choice.
   * For example, symbol=MSFT
   */
  private String symbol;

  /**
   * The generic number of elements to output
   */
  private OutputSize outputsize;
}
