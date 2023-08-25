package com.korbyte.alphavantage.core.daily_adjusted;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.DailyResponse;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Daily Adjusted API
 * <p>
 *   This API returns raw (as-traded) daily open/high/low/close/volume values, adjusted close values, and historical
 *   split/dividend events of the global equity specified, covering 20+ years of historical data. The OHLCV data is
 *   sometimes called "candles" in finance literature.
 * </p>
 * see <a href="https://www.alphavantage.co/documentation/#dailyadj">Daily Adjusted Api</a>
 */
public class DailyAdjustedApi extends AlphaVantageApi {
  public DailyAdjustedApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * This API returns raw (as-traded) daily time series
   *
   * @param params DailyParams object
   * @return DailyResponse
   */
  public DailyAdjustedResponse get(DailyAdjustedParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, DailyAdjustedResponse.class);
  }
}
