package com.korbyte.alphavantage.core.daily.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.baseModels.BasePositionData;
import lombok.Data;

@Data
public class DailyPositionData extends BasePositionData {

  @JsonProperty(required = true, value = "5. volume")
  private Integer volume;
}
