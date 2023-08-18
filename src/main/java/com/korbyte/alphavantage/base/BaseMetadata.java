package com.korbyte.alphavantage.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Alpha Vantage API BaseMetadata
 */
@Data
public abstract class BaseMetadata {

  @JsonProperty(required = true, value = "1. Information")
  private String information;

  @JsonProperty(required = true, value = "2. Symbol")
  private String symbol;

  @JsonProperty(value = "3. Last Refreshed")
  private String lastRefreshed;
}
