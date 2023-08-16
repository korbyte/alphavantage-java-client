package com.korbyte.alphavantage.core;

import com.korbyte.alphavantage.AlphaVantageApi;
import lombok.Data;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.DailyApi;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true, chain = true)
public class CoreApi extends AlphaVantageApi {

  private final DailyApi daily;

  public CoreApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
    this.daily = new DailyApi(config, client);
  }
}
