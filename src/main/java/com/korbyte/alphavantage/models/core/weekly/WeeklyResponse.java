package com.korbyte.alphavantage.models.core.weekly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.models.metadata.MetadataWeeklyMonthly;
import com.korbyte.alphavantage.models.positiondata.PositionData;
import lombok.Data;

import java.util.Map;

@Data
public class WeeklyResponse {
  @JsonProperty("Meta Data")
  private MetadataWeeklyMonthly metaData;

  @JsonProperty("Weekly Time Series")
  private Map<String, PositionData> timeSeriesWeekly;
}
