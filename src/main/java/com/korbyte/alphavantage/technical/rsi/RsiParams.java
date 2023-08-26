package com.korbyte.alphavantage.technical.rsi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.technical.rsi.models.RsiInterval;
import com.korbyte.alphavantage.types.ApiFunction;
import com.korbyte.alphavantage.types.SeriesType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Representation of the RSI API parameters
 *
 * @see <a href="https://www.alphavantage.co/documentation/#rsi">RSI API</a>
 */
@Data
public class RsiParams {
  /**
   * The technical indicator to call
   * set to RSI
   */
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.RSI;

  /**
   * The name of the ticker of your choice.
   * For example, symbol=IBM
   */
  private String symbol;

  /**
   * Time interval between two consecutive data points in the time series.
   * The following values are supported: 1min, 5min, 15min, 30min, 60min, daily, weekly, monthly
   */
  private RsiInterval interval;

  /**
   * Note:
   * this parameter is ONLY applicable to intraday intervals
   * (1min, 5min, 15min, 30min, and 60min) for the equity markets.
   * The daily/weekly/monthly intervals are agnostic to this parameter.
   * By default, this parameter is not set and the technical indicator values will be calculated based on the most
   * recent 30 days of intraday data.
   * You can use the month parameter (in YYYY-MM format) to compute intraday technical indicators for a specific month
   * in history.
   * For example, month=2009-01.
   * Any month equal to or later than 2000-01 (January 2000) is supported.
   */
  private String month;

  /**
   * The time period of the RSI.
   * Number of data points used to calculate each RSI value. Positive integers are accepted (e.g., time_period=60, time_period=200)
   * required
   */
  @JsonProperty("time_period")
  private Integer timePeriod;

  /**
   * The desired price type in the time series. Four types are supported: close, open, high, low
   */
  @JsonProperty("series_type")
  private SeriesType seriesType;
}
