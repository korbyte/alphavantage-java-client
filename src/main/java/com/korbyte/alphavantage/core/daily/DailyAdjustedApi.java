package com.korbyte.alphavantage.core.daily;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.models.adjusted.DailyAdjustedParams;
import com.korbyte.alphavantage.core.daily.models.adjusted.DailyAdjustedResponse;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class DailyAdjustedApi extends AlphaVantageApi {
  public DailyAdjustedApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * This API returns raw (as-traded) daily time series
   * @param params DailyParams object
   * @return DailyResponse
   * @throws URISyntaxException
   * @throws IOException
   */
  public DailyAdjustedResponse get(DailyAdjustedParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, DailyAdjustedResponse.class);
  }
}
