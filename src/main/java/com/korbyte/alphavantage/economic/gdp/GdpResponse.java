package com.korbyte.alphavantage.economic.gdp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.types.interval_models.YearIntervalType;
import lombok.Data;

import java.util.List;

@Data
public class GdpResponse {
  @JsonProperty("name")
  private String name;
  @JsonProperty("interval")
  private YearIntervalType intervalType;
  @JsonProperty("unit")
  private String unit;
  @JsonProperty("data")
  private List<GdpPositionData> data;
}
