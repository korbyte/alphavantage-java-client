package com.korbyte.alphavantage.economic.gdp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GdpPositionData {
  @JsonProperty("date")
  private String date;
  @JsonProperty("value")
  private String value;
}
