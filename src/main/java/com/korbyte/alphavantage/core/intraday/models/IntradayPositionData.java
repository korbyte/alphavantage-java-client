package com.korbyte.alphavantage.core.intraday.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BasePositionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class IntradayPositionData extends BasePositionData {
  @JsonProperty(required = true, value = "5. volume")
  private BigInteger volume;
}
