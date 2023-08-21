package com.korbyte.alphavantage.core.weekly_adjusted;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.daily.models.DailyMetadata;
import com.korbyte.alphavantage.core.weekly_adjusted.models.WeeklyAdjustedPositionData;
import lombok.Data;

import java.util.Map;

@Data
public class WeeklyAdjustedResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Weekly Adjusted Time Series")
  private Map<String, WeeklyAdjustedPositionData> timeSeriesAdjustedWeekly;
}
