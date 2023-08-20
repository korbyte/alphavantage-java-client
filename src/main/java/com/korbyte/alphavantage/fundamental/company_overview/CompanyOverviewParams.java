package com.korbyte.alphavantage.fundamental.company_overview;

import com.korbyte.alphavantage.types.ApiFunction;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class CompanyOverviewParams {
  /**
   * By default, function=TIME_SERIES_DAILY.
   * Does not change
   */
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.COMPANY_OVERVIEW;

  /**
   * The name of the equity of your choice.
   * For example, symbol=MSFT
   */
  private String symbol;
}
