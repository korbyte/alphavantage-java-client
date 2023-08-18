package com.korbyte.alphavantage.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public abstract class BasePositionData {
  @JsonProperty(required = true, value = "1. open")
  private Float open;

  @JsonProperty(required = true, value = "2. high")
  private Float high;

  @JsonProperty(required = true, value = "3. low")
  private Float low;

  @JsonProperty(required = true, value = "4. close")
  private Float close;
}
