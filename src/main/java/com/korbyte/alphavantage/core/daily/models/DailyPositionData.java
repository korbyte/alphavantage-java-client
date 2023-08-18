package com.korbyte.alphavantage.core.daily.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BasePositionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class DailyPositionData extends BasePositionData {

  @JsonProperty(required = true, value = "5. volume")
  private Double volume;
}
