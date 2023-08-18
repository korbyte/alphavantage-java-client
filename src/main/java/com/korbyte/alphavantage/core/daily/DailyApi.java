package com.korbyte.alphavantage.core.daily;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.models.adjusted.DailyAdjustedParams;
import com.korbyte.alphavantage.core.daily.models.adjusted.DailyAdjustedResponse;
import com.korbyte.alphavantage.core.daily.models.DailyParams;
import com.korbyte.alphavantage.core.daily.models.DailyResponse;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class DailyApi extends AlphaVantageApi {
  public DailyApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public DailyResponse get(DailyParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, DailyResponse.class);
  }

  /**
   * This API returns raw (as-traded) daily time series
   * (date, daily open, daily high, daily low, daily close, daily volume) of the global equity specified,
   * covering 20+ years of historical data.
   * @param params
   * @return
   * @throws URISyntaxException
   * @throws IOException
   */
  public DailyAdjustedResponse getAdjusted(DailyAdjustedParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, DailyAdjustedResponse.class);
  }
}
