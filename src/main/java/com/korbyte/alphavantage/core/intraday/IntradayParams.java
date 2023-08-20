package com.korbyte.alphavantage.core.intraday;

import com.korbyte.alphavantage.params.ApiFunction;
import com.korbyte.alphavantage.params.DataType;
import com.korbyte.alphavantage.params.OutputSize;
import lombok.AccessLevel;
import lombok.Setter;

public class IntradayParams {

  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_INTRADAY;

  /**
   * The name of the equity of your choice.
   * For example, symbol=MSFT
   */
  private String symbol;

  private String interval;

  private boolean adjusted;

  private boolean extended_hours;

  private String month;

  private OutputSize outputsize;

  private DataType datatype;

  private String apikey;
}
