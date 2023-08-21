package com.korbyte.alphavantage.technical.rsi;

import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.interval_models.IntervalType;
import com.korbyte.alphavantage.types.interval_models.MinIntervalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class RsiParams {
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.RSI;

  private String symbol;

  private intervalType;

}
