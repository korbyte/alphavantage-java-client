package com.korbyte.alphavantage.core.intraday;

import com.korbyte.alphavantage.params.ApiFunction;
import com.korbyte.alphavantage.params.DataType;
import com.korbyte.alphavantage.params.OutputSize;
import com.korbyte.alphavantage.params.IntervalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Representation of the parameters for the intraday data API from alphavantage.co
 * @see <a href="https://www.alphavantage.co/documentation/#intraday">https://www.alphavantage.co/documentation/#intraday</a>
 */
@Data
public class IntradayParams {

  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_INTRADAY;

  private String apikey;

  private String symbol;

  private IntervalType interval;

  private boolean adjusted;

  private boolean extended_hours;

  private String month;

  private OutputSize outputsize;
}
