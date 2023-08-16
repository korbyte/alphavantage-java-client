package com.korbyte.alphavantage.core;

import lombok.Data;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.DailyApi;
import okhttp3.OkHttpClient;

@Data
public class CoreApi {

  private final AlphaVantageConfig config;
  private final OkHttpClient client;
  private final DailyApi daily;

  public CoreApi(AlphaVantageConfig config, OkHttpClient client) {
    this.config = config;
    this.client = client;
    this.daily = new DailyApi(config, client);
  }
}
