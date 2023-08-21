package com.korbyte.alphavantage.technical;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.technical.rsi.RsiApi;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true, chain = true)
public class TechnicalApi extends AlphaVantageApi {

  private final RsiApi rsiApi;

  public TechnicalApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
    this.rsiApi = new RsiApi(config, client);
  }
}
