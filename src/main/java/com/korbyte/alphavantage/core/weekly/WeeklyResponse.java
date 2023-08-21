package com.korbyte.alphavantage.core.weekly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.weekly.models.WeeklyMetadata;
import com.korbyte.alphavantage.core.weekly.models.WeeklyPositionData;
import lombok.Data;

import java.util.Map;

/**
 * AlphaVantage Weekly response model
 */
@Data
public class WeeklyResponse {
  @JsonProperty("Meta Data")
  private WeeklyMetadata metaData;

  @JsonProperty("Weekly Time Series")
  private Map<String, WeeklyPositionData> timeSeriesWeekly;
}
