package com.korbyte.alphavantage.core.weekly;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.weekly.models.WeeklyParams;
import com.korbyte.alphavantage.core.weekly.models.WeeklyResponse;
import com.korbyte.alphavantage.core.weekly.models.adjusted.WeeklyAdjustedParams;
import com.korbyte.alphavantage.core.weekly.models.adjusted.WeeklyAdjustedResponse;
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
   * @throws URISyntaxException
   * @throws IOException
   */
  public WeeklyResponse get(WeeklyParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, WeeklyResponse.class);
  }

  /**
   * Get weekly adjusted time series
   *
   * @param params WeeklyAdjustedParams
   * @return WeeklyAdjustedResponse
   * @throws URISyntaxException
   * @throws IOException
   */
  public WeeklyAdjustedResponse getAdjusted(WeeklyAdjustedParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, WeeklyAdjustedResponse.class);
  }
}
