package com.korbyte.alphavantage.core.monthly;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
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
   * @throws URISyntaxException
   * @throws IOException
   */
  public MonthlyResponse get(MonthlyParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, MonthlyResponse.class);
  }
}
