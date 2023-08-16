package com.korbyte.alphavantage.models.positiondata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdjustedPositionData {
  @JsonProperty(required = true, value = "5. adjusted close")
  private Float adjustedClose;

  @JsonProperty(required = true, value = "6. volume")
  private Integer volume;

  @JsonProperty(required = true, value = "7. dividend amount")
  private Float dividendAmount;
}
