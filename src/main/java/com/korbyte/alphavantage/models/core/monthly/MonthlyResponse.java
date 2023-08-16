package com.korbyte.alphavantage.models.core.monthly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.metadata.MetadataWeeklyMonthly;
import com.korbyte.alphavantage.models.positiondata.PositionData;
import lombok.Data;

import java.util.Map;

@Data
public class MonthlyResponse {
  @JsonProperty("Meta Data")
  private MetadataWeeklyMonthly metaData;

  @JsonProperty("Monthly Time Series")
  private Map<String, PositionData> timeSeriesMonthly;
}
