package com.korbyte.alphavantage.technical.rsi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.technical.rsi.models.RsiMetadata;
import com.korbyte.alphavantage.technical.rsi.models.RsiPositionData;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class RsiResponse {
  @JsonProperty("Meta Data")
  private RsiMetadata metaData;

  @JsonProperty("Technical Analysis: RSI")
  private Map<Date, RsiPositionData> rsiPositionalData;
}
