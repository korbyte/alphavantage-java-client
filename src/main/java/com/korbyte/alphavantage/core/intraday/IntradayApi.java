package com.korbyte.alphavantage.core.intraday;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

public class IntradayApi extends AlphaVantageApi {
  public IntradayApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }
}
