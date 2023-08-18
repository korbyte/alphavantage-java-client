package com.korbyte.alphavantage.core.weekly.models;

import com.korbyte.alphavantage.params.ApiFunction;
import com.korbyte.alphavantage.params.DataType;
import com.korbyte.alphavantage.params.OutputSize;
import lombok.Data;

/**
 * AlphaVantage Weekly request params model
 */
@Data
public class WeeklyParams {
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

  /**
   * JSON or CSV.
   * By default, datatype=json.
   */
  private DataType datatype;
}
