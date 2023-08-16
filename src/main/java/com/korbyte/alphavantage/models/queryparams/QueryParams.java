package com.korbyte.alphavantage.models.queryparams;

import com.korbyte.alphavantage.base.ApiFunction;
import com.korbyte.alphavantage.models.queryparams.OutputSize;
import lombok.Data;

@Data
public class QueryParams {
  private ApiFunction apiFunction;
  private String symbol;
  OutputSize outputsize = OutputSize.FULL;
}
