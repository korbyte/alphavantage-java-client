package com.korbyte.alphavantage.core;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.daily.DailyAdjustedApi;
import com.korbyte.alphavantage.core.daily.DailyApi;
import com.korbyte.alphavantage.core.global_market_status.GlobalMarketStatusApi;
import com.korbyte.alphavantage.core.monthly.MonthlyAdjustedApi;
import com.korbyte.alphavantage.core.monthly.MonthlyApi;
import com.korbyte.alphavantage.core.weekly.WeeklyAdjustedApi;
import com.korbyte.alphavantage.core.weekly.WeeklyApi;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true, chain = true)
public class CoreApi extends AlphaVantageApi {

  private final DailyApi daily;
  private final DailyAdjustedApi dailyAdjusted;
  private final WeeklyApi weekly;
  private final WeeklyAdjustedApi weeklyAdjusted;
  private final MonthlyApi monthly;
  private final MonthlyAdjustedApi monthlyAdjusted;
  private final GlobalMarketStatusApi globalMarketStatus;

  public CoreApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
    this.daily = new DailyApi(config, client);
    this.dailyAdjusted = new DailyAdjustedApi(config, client);
    this.weekly = new WeeklyApi(config, client);
    this.weeklyAdjusted = new WeeklyAdjustedApi(config, client);
    this.monthly = new MonthlyApi(config, client);
    this.monthlyAdjusted = new MonthlyAdjustedApi(config, client);
    this.globalMarketStatus = new GlobalMarketStatusApi(config, client);
  }
}
