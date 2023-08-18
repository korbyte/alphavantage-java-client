package com.korbyte.alphavantage.core.monthly;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * AlphaVantage Monthly response model
 */
@Data
public class MonthlyResponse {
  @JsonProperty("Meta Data")
  private MonthlyMetadata metaData;

  @JsonProperty("Monthly Time Series")
  private Map<String, MonthlyPositionData> timeSeriesMonthly;
}
