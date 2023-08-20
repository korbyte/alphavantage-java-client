package com.korbyte.alphavantage.economic.gdp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class GdpApi extends AlphaVantageApi {

  public GdpApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public GdpResponse get(GdpParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, GdpResponse.class);
  }
}
