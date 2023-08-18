package com.korbyte.alphavantage.core.weekly.models.adjusted;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.daily.DailyMetadata;
import lombok.Data;

import java.util.Map;

@Data
public class WeeklyAdjustedResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Weekly Adjusted Time Series")
  private Map<String, WeeklyAdjustedPositionData> timeSeriesAdjustedWeekly;
}
