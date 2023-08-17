package com.korbyte.alphavantage.core.weekly;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.weekly.models.WeeklyParams;
import com.korbyte.alphavantage.core.weekly.models.WeeklyResponse;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeeklyApi extends AlphaVantageApi {
  public WeeklyApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public WeeklyResponse get(WeeklyParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, WeeklyResponse.class);
  }


}
