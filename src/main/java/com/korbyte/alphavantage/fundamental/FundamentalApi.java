package com.korbyte.alphavantage.fundamental;

import com.korbyte.alphavantage.AlphaVantageConfig;
import lombok.Data;
import okhttp3.OkHttpClient;

@Data
public class FundamentalApi {

  private final AlphaVantageConfig config;

  private final OkHttpClient client;

  public FundamentalApi(AlphaVantageConfig config, OkHttpClient client) {
    this.config = config;
    this.client = client;
    //this.daily = new DailyApi(config, client);
  }
}
