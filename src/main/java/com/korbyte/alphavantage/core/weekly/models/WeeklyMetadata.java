package com.korbyte.alphavantage.core.weekly.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeeklyMetadata {
  @JsonProperty(required = true, value = "1. Information")
  private String information;

  @JsonProperty(required = true, value = "2. Symbol")
  private String symbol;

  @JsonProperty(value = "3. Last Refreshed")
  private String lastRefreshed;

  @JsonProperty(value = "4. Time Zone")
  private String timeZone;
}
