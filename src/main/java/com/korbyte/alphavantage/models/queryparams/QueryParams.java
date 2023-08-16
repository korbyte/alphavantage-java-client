package com.korbyte.alphavantage.models.queryparams;

import com.korbyte.alphavantage.ApiFunction;
import lombok.Data;

@Data
public class QueryParams {
  private ApiFunction apiFunction;
  private String symbol;
  OutputSize outputsize = OutputSize.FULL;
  DataType datatype = DataType.JSON;
}
