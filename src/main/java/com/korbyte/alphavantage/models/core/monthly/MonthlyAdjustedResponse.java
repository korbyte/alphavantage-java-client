package com.korbyte.alphavantage.models.core.monthly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.metadata.MetadataWeeklyMonthly;
import com.korbyte.alphavantage.models.positiondata.AdjustedPositionData;
import lombok.Data;

import java.util.Map;

@Data
public class MonthlyAdjustedResponse {
  @JsonProperty("Meta Data")
  private MetadataWeeklyMonthly metaData;

  @JsonProperty("Monthly Adjusted Time Series")
  private Map<String, AdjustedPositionData> timeSeriesMonthlyAdjusted;
}
