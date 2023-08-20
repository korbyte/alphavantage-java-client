package com.korbyte.alphavantage.core.intraday;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class IntradayApi extends AlphaVantageApi {
  public IntradayApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public IntradayResponse get(IntradayParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, IntradayResponse.class);
  }
}
