package com.korbyte.alphavantage.core.monthly.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BasePositionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class MonthlyPositionData extends BasePositionData {

  @JsonProperty(required = true, value = "5. volume")
  private BigInteger volume;
}
