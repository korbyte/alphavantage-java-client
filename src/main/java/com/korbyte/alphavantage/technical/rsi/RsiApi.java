package com.korbyte.alphavantage.technical.rsi;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

public class RsiApi extends AlphaVantageApi  {

  public RsiApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public RsiResponse get(RsiParams params) throws Exception {
    String data = this.query(params);
    return RsiResponse.from(data);
  }
}
