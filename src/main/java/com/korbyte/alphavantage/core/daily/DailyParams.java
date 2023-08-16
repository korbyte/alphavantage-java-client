package com.korbyte.alphavantage.core.daily;

import com.korbyte.alphavantage.ApiFunction;
import lombok.Data;

@Data()
public class DailyParams {

  private ApiFunction function;

  private String apiKey;

  private String symbol;

  private String outputSize;

  private String datatype;
}
