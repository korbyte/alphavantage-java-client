package com.korbyte.alphavantage.core.monthly.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.baseModels.BasePositionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MonthlyPositionData extends BasePositionData {

  @JsonProperty(required = true, value = "5. volume")
  private Integer volume;
}
