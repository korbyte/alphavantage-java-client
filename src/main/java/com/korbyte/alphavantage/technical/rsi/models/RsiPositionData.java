package com.korbyte.alphavantage.technical.rsi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RsiPositionData {
  @JsonProperty("RSI")
  private float rsi;
}
