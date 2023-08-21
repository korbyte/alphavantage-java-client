package com.korbyte.alphavantage.core.monthly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.monthly.models.MonthlyMetadata;
import com.korbyte.alphavantage.core.monthly.models.MonthlyPositionData;
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
