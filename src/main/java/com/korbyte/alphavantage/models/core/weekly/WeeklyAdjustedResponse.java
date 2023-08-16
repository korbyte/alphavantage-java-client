package com.korbyte.alphavantage.models.core.weekly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.metadata.MetadataWeeklyMonthly;
import com.korbyte.alphavantage.models.positiondata.AdjustedPositionData;
import lombok.Data;

import java.util.Map;

@Data
public class WeeklyAdjustedResponse {
  @JsonProperty("Meta Data")
  private MetadataWeeklyMonthly metaData;

  @JsonProperty("Weekly Adjusted Time Series")
  private Map<String, AdjustedPositionData> timeSeriesWeeklyAdjusted;
}
