package com.korbyte.alphavantage.core.intraday;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class IntradayApi extends AlphaVantageApi {
  public IntradayApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public IntradayResponse get(IntradayParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, IntradayResponse.class);
  }
}
