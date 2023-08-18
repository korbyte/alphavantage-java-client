package com.korbyte.alphavantage.core.weekly_adjusted;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.weekly_adjusted.WeeklyAdjustedParams;
import com.korbyte.alphavantage.core.weekly_adjusted.WeeklyAdjustedResponse;
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
   * @throws URISyntaxException
   * @throws IOException
   */
  public WeeklyAdjustedResponse get(WeeklyAdjustedParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, WeeklyAdjustedResponse.class);
  }
}
