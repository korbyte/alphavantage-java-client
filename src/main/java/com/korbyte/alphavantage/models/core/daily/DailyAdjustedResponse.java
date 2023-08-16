package com.korbyte.alphavantage.models.core.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.metadata.MetadataDaily;
import com.korbyte.alphavantage.models.positiondata.AdjustedPositionData;
import lombok.Data;

import java.util.Map;

@Data
public class DailyAdjustedResponse {
  @JsonProperty("Meta Data")
  private MetadataDaily metaData;

  @JsonProperty("Time Series (Daily)")
  private Map<String, AdjustedPositionData> timeSeriesDailyAdjusted;
}
