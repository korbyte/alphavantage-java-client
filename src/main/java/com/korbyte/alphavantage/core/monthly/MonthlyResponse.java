package com.korbyte.alphavantage.core.monthly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.core.monthly.models.MonthlyMetadata;
import com.korbyte.alphavantage.core.monthly.models.MonthlyPositionData;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateKeyDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * AlphaVantage Monthly response model
 */
@Data
public class MonthlyResponse {
  @JsonProperty("Meta Data")
  private MonthlyMetadata metaData;

  @JsonProperty("Monthly Time Series")
  @JsonDeserialize(keyUsing = EasternZonedDateKeyDeserializer.class)
  private Map<ZonedDateTime, MonthlyPositionData> timeSeriesMonthly;
}
