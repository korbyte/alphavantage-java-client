package com.korbyte.models;

import lombok.Data;

@Data
public class QueryParams {
  private Function function;
  private String symbol;
  private String apiKey;
}
