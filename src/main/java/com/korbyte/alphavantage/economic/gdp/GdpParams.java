package com.korbyte.alphavantage.economic.gdp;

import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.interval_models.YearIntervalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Representation of the parameters for the Real GDP data API from alphavantage.co
 *
 * @see <a href="https://www.alphavantage.co/documentation/#real-gdp">https://www.alphavantage.co/documentation/#real-gdp</a>
 */
@Data
public class GdpParams {
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.GDP;

  private YearIntervalType intervalType;
}
