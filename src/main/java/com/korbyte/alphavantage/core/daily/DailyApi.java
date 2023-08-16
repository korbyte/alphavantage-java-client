package com.korbyte.alphavantage.core.daily;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.params.ApiFunction;
import com.korbyte.alphavantage.AlphaVantageApi;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class DailyApi extends AlphaVantageApi {
  public DailyApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public DailyResponse get(DailyParams params) throws URISyntaxException, IOException {
    params.setFunction(ApiFunction.TIME_SERIES_DAILY);
    String data = this.query(params);
    return new ObjectMapper().readValue(data, DailyResponse.class);
  }
}
