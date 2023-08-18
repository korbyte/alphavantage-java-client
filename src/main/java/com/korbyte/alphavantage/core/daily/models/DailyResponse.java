package com.korbyte.alphavantage.core.daily.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class DailyResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Time Series (Daily)")
  private Map<String, DailyPositionData> timeSeriesDaily;
}
