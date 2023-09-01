package com.korbyte.alphavantage.technical.rsi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.technical.rsi.models.RsiMetadata;
import com.korbyte.alphavantage.technical.rsi.models.RsiPositionData;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateKeyDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
public class RsiResponse {
  @JsonProperty("Meta Data")
  private RsiMetadata metaData;

  @JsonProperty("Technical Analysis: RSI")
  @JsonDeserialize(keyUsing = EasternZonedDateKeyDeserializer.class)
  private Map<ZonedDateTime, RsiPositionData> rsiPositionalData;
}
