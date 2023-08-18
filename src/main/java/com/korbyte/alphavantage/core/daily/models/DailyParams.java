package com.korbyte.alphavantage.core.daily.models;

import com.korbyte.alphavantage.params.ApiFunction;
import com.korbyte.alphavantage.params.DataType;
import com.korbyte.alphavantage.params.OutputSize;
import lombok.Data;

@Data
public class DailyParams {
  private ApiFunction function = ApiFunction.TIME_SERIES_DAILY;
  private String symbol;
  private OutputSize outputSize;
  private DataType datatype;
}
