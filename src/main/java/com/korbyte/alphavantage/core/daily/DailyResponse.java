package com.korbyte.alphavantage.core.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.metadata.MetadataDaily;
import lombok.Data;

import java.util.Map;

@Data
public class DailyResponse {
  @JsonProperty("Meta Data")
  private MetadataDaily metaData;

  @JsonProperty("Time Series (Daily)")
  private Map<String, DailyData> timeSeriesDaily;
}