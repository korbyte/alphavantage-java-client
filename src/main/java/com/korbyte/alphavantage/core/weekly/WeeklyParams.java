package com.korbyte.alphavantage.core.weekly;

import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.OutputSize;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * AlphaVantage Weekly request params model
 */
@Data
public class WeeklyParams {

  /**
   * By default, function=TIME_SERIES_WEEKLY.
   * Does not change
   */
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_WEEKLY;

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
