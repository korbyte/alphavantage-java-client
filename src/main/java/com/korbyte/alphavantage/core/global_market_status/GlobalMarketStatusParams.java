package com.korbyte.alphavantage.core.global_market_status;

import com.korbyte.alphavantage.params.ApiFunction;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class GlobalMarketStatusParams {
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.MARKET_STATUS;
}
