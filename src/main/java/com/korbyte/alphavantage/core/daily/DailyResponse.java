package com.korbyte.alphavantage.core.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.daily.models.DailyMetadata;
import com.korbyte.alphavantage.core.daily.models.DailyPositionData;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateKeyDeserializer;
import lombok.Data;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
public class DailyResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Time Series (Daily)")
  @JsonDeserialize(keyUsing = EasternZonedDateKeyDeserializer.class)
  private Map<ZonedDateTime, DailyPositionData> timeSeriesDaily;
}
