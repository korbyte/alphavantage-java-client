package com.korbyte.alphavantage.core.monthly_adjusted;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
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
   */
  public MonthlyAdjustedResponse get(MonthlyAdjustedParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, MonthlyAdjustedResponse.class);
  }
}
