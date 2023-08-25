package com.korbyte.alphavantage.core.weekly;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Weekly API
 */
public class WeeklyApi extends AlphaVantageApi {
  public WeeklyApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * Get weekly time series
   *
   * @param params WeeklyParams
   * @return WeeklyResponse
   */
  public WeeklyResponse get(WeeklyParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, WeeklyResponse.class);
  }
}
