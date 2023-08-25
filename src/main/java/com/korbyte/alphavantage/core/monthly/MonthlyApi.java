package com.korbyte.alphavantage.core.monthly;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Monthly API
 */
public class MonthlyApi extends AlphaVantageApi {
  public MonthlyApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * Get Monthly time series
   *
   * @param params MonthlyParams
   * @return MonthlyResponse
   */
  public MonthlyResponse get(MonthlyParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, MonthlyResponse.class);
  }
}
