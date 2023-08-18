package com.korbyte.alphavantage.core.monthly;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.monthly.models.adjusted.MonthlyAdjustedParams;
import com.korbyte.alphavantage.core.monthly.models.adjusted.MonthlyAdjustedResponse;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class MonthlyAdjustedApi extends AlphaVantageApi {
  public MonthlyAdjustedApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * Get Monthly adjusted time series
   *
   * @param params MonthlyAdjustedParams
   * @return MonthlyAdjustedResponse
   * @throws URISyntaxException
   * @throws IOException
   */
  public MonthlyAdjustedResponse get(MonthlyAdjustedParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, MonthlyAdjustedResponse.class);
  }
}
