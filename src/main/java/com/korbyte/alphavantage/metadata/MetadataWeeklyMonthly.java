package com.korbyte.alphavantage.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MetadataWeeklyMonthly extends BaseMetadata {
  @JsonProperty(value = "4. Time Zone")
  private String timeZone;
}
