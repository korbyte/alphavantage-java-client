package com.korbyte.alphavantage.core.intraday;

import com.korbyte.alphavantage.params.ApiFunction;
import com.korbyte.alphavantage.params.DataType;
import com.korbyte.alphavantage.params.OutputSize;
import lombok.Data;

@Data
public class IntradayParams {

  private ApiFunction function = ApiFunction.TIME_SERIES_INTRADAY;

  private String apikey;

  private String symbol;

  private String interval;

  private boolean adjusted;

  private boolean extended_hours;

  private String month;

  private OutputSize outputsize;

  private DataType datatype;
}
