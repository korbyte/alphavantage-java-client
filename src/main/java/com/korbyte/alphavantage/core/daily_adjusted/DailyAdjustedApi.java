package com.korbyte.alphavantage.core.daily_adjusted;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

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
  public DailyAdjustedResponse get(DailyAdjustedParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, DailyAdjustedResponse.class);
  }
}
