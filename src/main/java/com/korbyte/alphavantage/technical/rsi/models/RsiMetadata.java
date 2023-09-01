package com.korbyte.alphavantage.technical.rsi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.types.SeriesType;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class RsiMetadata {
  @JsonProperty("1: Symbol")
  private String symbol;

  @JsonProperty("2: Indicator")
  private String indicator;

  @JsonProperty("3: Last Refreshed")
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime lastRefreshed;

  @JsonProperty("4: Interval")
  private RsiInterval interval;

  @JsonProperty("5: Time Period")
  private Integer timePeriod;

  @JsonProperty("6: Series Type")
  private SeriesType seriesType;

  @JsonProperty("7: Time Zone")
  private String timeZone;
}
