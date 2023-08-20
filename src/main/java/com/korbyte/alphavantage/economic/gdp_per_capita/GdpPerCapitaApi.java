package com.korbyte.alphavantage.economic.gdp_per_capita;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.economic.gdp.GdpResponse;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class GdpPerCapitaApi extends AlphaVantageApi {

  public GdpPerCapitaApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public GdpResponse get(GdpPerCapitaParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, GdpResponse.class);
  }
}
