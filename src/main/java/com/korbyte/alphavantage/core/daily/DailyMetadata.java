package com.korbyte.alphavantage.core.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BaseMetadata;

public class DailyMetadata extends BaseMetadata {
  @JsonProperty(value = "4. Output Size")
  private String outputSize;

  @JsonProperty(value = "5. Time Zone")
  private String timeZone;
}
