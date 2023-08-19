package com.korbyte.alphavantage.core.monthly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BasePositionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class MonthlyPositionData extends BasePositionData {

  @JsonProperty(required = true, value = "5. volume")
  private Integer volume;
}
