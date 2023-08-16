package com.korbyte.alphavantage.core;

import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.DailyParams;
import com.korbyte.alphavantage.core.daily.DailyResponse;
import com.korbyte.alphavantage.core.daily.DailyService;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class CoreApi {

  private final AlphaVantageConfig config;

  private final OkHttpClient client;

  public CoreApi(AlphaVantageConfig config, OkHttpClient client) {
    this.config = config;
    this.client = client;
  }

  public DailyResponse getDaily(DailyParams params) throws URISyntaxException, IOException {
    DailyService dailyService = new DailyService(this.config, this.client);
    return dailyService.get(params);
  }
}
