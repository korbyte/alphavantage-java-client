package com.korbyte.alphavantage.core.weekly.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
