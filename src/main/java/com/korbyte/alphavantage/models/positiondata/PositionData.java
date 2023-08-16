package com.korbyte.alphavantage.models.positiondata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionData extends BasePositionData {
  @JsonProperty(required = true, value = "5. volume")
  private Integer volume;
}
