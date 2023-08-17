package com.korbyte.alphavantage.core;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.DailyApi;
import com.korbyte.alphavantage.core.weekly.WeeklyApi;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true, chain = true)
public class CoreApi extends AlphaVantageApi {

  private final DailyApi daily;
  private final WeeklyApi weekly;

  public CoreApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
    this.daily = new DailyApi(config, client);
    this.weekly = new WeeklyApi(config, client);
  }
}
