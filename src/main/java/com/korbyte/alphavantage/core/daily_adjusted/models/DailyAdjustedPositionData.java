package com.korbyte.alphavantage.core.daily_adjusted.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BasePositionData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class DailyAdjustedPositionData extends BasePositionData {
  @JsonProperty(required = true, value = "5. adjusted close")
  private Float adjustedClose;

  @JsonProperty(required = true, value = "6. volume")
  private BigInteger volume;

  @JsonProperty(required = true, value = "7. dividend amount")
  private Float dividendAmount;

  @JsonProperty(required = true, value = "8. split coefficient")
  private Float splitCoefficient;
}
