package com.korbyte.alphavantage.core.global_market_status.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MarketData {
  @JsonProperty("market_type")
  private String marketType;

  @JsonProperty("region")
  private String region;

  @JsonProperty("primary_exchanges")
  private String primaryExchanges;

  @JsonProperty("local_open")
  private String localOpen;

  @JsonProperty("local_close")
  private String localClose;

  @JsonProperty("current_status")
  private String currentStatus;

  @JsonProperty("notes")
  private String notes;
}
