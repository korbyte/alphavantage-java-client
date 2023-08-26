package com.korbyte.alphavantage.core.intraday;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.OutputSize;
import com.korbyte.alphavantage.types.interval_models.MinIntervalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Representation of the parameters for the intraday data API from alphavantage.co
 *
 * @see <a href="https://www.alphavantage.co/documentation/#intraday">https://www.alphavantage.co/documentation/#intraday</a>
 */
@Data
public class IntradayParams {

  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.TIME_SERIES_INTRADAY;

  private String apikey;

  private String symbol;

  private MinIntervalType interval;

  private boolean adjusted;

  private boolean extended_hours;

  private String month;

  @JsonProperty(value = "outputsize")
  private OutputSize outputSize;
}
