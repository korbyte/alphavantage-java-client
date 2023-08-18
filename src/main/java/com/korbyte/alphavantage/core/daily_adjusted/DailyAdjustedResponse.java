package com.korbyte.alphavantage.core.daily_adjusted;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.daily.DailyMetadata;
import lombok.Data;

import java.util.Map;

@Data
public class DailyAdjustedResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Time Series (Daily)")
  private Map<String, DailyAdjustedPositionData> timeSeriesAdjustedDaily;
}
