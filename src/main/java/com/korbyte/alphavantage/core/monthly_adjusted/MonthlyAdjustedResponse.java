package com.korbyte.alphavantage.core.monthly_adjusted;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.daily.DailyMetadata;
import lombok.Data;

import java.util.Map;

@Data
public class MonthlyAdjustedResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Monthly Adjusted Time Series")
  private Map<String, MonthlyAdjustedPositionData> timeSeriesAdjustedMonthly;
}
