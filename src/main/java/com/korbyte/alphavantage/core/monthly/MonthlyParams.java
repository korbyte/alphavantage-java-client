package com.korbyte.alphavantage.core.monthly;

import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.OutputSize;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * AlphaVantage Monthly request params model
 */
@Data
public class MonthlyParams {

  /**
   * By default, function=TIME_SERIES_MONTHLY.
   * Does not change
   */
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_MONTHLY;

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
