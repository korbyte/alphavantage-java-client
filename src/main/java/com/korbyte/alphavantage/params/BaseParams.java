package com.korbyte.alphavantage.params;

import lombok.Data;

@Data
public class BaseParams {
  private ApiFunction function;
  private String apikey;
}
