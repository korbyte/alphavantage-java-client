package com.korbyte.alphavantage.core.weekly.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeeklyPositionData {
  @JsonProperty(required = true, value = "1. open")
  private Float open;

  @JsonProperty(required = true, value = "2. high")
  private Float high;

  @JsonProperty(required = true, value = "3. low")
  private Float low;

  @JsonProperty(required = true, value = "4. close")
  private Float close;

  @JsonProperty(required = true, value = "5. volume")
  private Integer volume;
}
