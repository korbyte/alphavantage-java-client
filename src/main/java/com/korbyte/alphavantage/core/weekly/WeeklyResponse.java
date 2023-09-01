package com.korbyte.alphavantage.core.weekly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.core.weekly.models.WeeklyMetadata;
import com.korbyte.alphavantage.core.weekly.models.WeeklyPositionData;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateKeyDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * AlphaVantage Weekly response model
 */
@Data
public class WeeklyResponse {
  @JsonProperty("Meta Data")
  private WeeklyMetadata metaData;

  @JsonProperty("Weekly Time Series")
  @JsonDeserialize(keyUsing = EasternZonedDateKeyDeserializer.class)
  private Map<ZonedDateTime, WeeklyPositionData> timeSeriesWeekly;
}
