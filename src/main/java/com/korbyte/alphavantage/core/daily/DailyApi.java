package com.korbyte.alphavantage.core.daily;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Daily API
 * <p>
 *   This API returns raw (as-traded) daily time series (date, daily open, daily high, daily low, daily close,
 *   daily volume) of the global equity specified, covering 20+ years of historical data. The OHLCV data is sometimes
 *   called "candles" in finance literature. If you are also interested in split/dividend-adjusted data, please use the
 *   Daily Adjusted API, which covers adjusted close values and historical split and dividend events.
 * </p>
 * see <a href="https://www.alphavantage.co/documentation/#daily">Daily Api</a>
 */
public class DailyApi extends AlphaVantageApi {
  public DailyApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * This API returns raw (as-traded) daily time series
   *
   * @param params DailyParams object
   * @return DailyResponse
   */
  public DailyResponse get(DailyParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return parseResponse(data, DailyResponse.class);
  }
}
