package com.korbyte.alphavantage.core.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.daily.models.DailyMetadata;
import com.korbyte.alphavantage.core.daily.models.DailyPositionData;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class DailyResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Time Series (Daily)")
  private Map<Date, DailyPositionData> timeSeriesDaily;
}
