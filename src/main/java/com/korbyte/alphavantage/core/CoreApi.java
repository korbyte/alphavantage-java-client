package com.korbyte.alphavantage.core;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.ApiFunction;
import com.korbyte.alphavantage.core.daily.DailyResponse;
import com.korbyte.alphavantage.models.queryparams.QueryParams;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class CoreApi extends AlphaVantageApi {

  public CoreApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public DailyResponse getDaily(String symbol) throws URISyntaxException, IOException {
    QueryParams params = new QueryParams();
    params.setSymbol(symbol);
    params.setApiFunction(ApiFunction.TIME_SERIES_DAILY);
    return this.query(DailyResponse.class, params);
  }
}
