package com.korbyte.alphavantage.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Alpha Vantage API BaseMetadata
 */
@Data
public abstract class BaseMetadata {

  @JsonProperty(required = true, value = "1. Information")
  private String information;

  @JsonProperty(required = true, value = "2. Symbol")
  private String symbol;

  @JsonProperty(value = "3. Last Refreshed")
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime lastRefreshed;
}
