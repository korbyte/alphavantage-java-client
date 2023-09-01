package com.korbyte.alphavantage.economic.gdp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * GDP position data
 */
@Data
public class GdpPositionData {
  @JsonProperty("date")
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime date;

  @JsonProperty("value")
  private Float value;
}
