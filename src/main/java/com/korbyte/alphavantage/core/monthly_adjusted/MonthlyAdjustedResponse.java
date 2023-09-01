package com.korbyte.alphavantage.core.monthly_adjusted;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.core.daily.models.DailyMetadata;
import com.korbyte.alphavantage.core.monthly_adjusted.models.MonthlyAdjustedPositionData;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateKeyDeserializer;
import lombok.Data;


import java.time.ZonedDateTime;
import java.util.Map;

@Data
public class MonthlyAdjustedResponse {
  @JsonProperty("Meta Data")
  private DailyMetadata metaData;

  @JsonProperty("Monthly Adjusted Time Series")
  @JsonDeserialize(keyUsing = EasternZonedDateKeyDeserializer.class)
  private Map<ZonedDateTime, MonthlyAdjustedPositionData> timeSeriesAdjustedMonthly;
}
