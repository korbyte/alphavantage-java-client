package com.korbyte.alphavantage.core.weekly_adjusted;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Weekly API
 */
public class WeeklyAdjustedApi extends AlphaVantageApi {
  public WeeklyAdjustedApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * Get weekly adjusted time series
   *
   * @param params WeeklyParams
   * @return WeeklyResponse
   */
  public WeeklyAdjustedResponse get(WeeklyAdjustedParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, WeeklyAdjustedResponse.class);
  }
}
