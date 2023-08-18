package com.korbyte.alphavantage.core.global_market_status.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GlobalMarketStatusResponse {
  @JsonProperty("endpoint")
  private String endpoint;

  @JsonProperty("markets")
  private List<MarketData> markets;
}
