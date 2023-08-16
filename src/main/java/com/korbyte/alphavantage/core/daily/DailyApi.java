package com.korbyte.alphavantage.core.daily;

import com.korbyte.alphavantage.AlphaVantageClient;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.base.ApiFunction;
import com.korbyte.alphavantage.base.ApiInterface;
import com.korbyte.alphavantage.models.QueryParams;
import com.korbyte.alphavantage.models.core.daily.DailyResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class DailyApi extends AlphaVantageClient implements ApiInterface<String, DailyResponse> {

  private static final ApiFunction FUNCTION = ApiFunction.DAILY;

  private final Class<DailyResponse> responseClass = DailyResponse.class;

  public DailyApi(AlphaVantageConfig config) {
    super(config);
  }

  public DailyResponse get(String tickerSymbol) throws URISyntaxException, IOException {
    //todo: figure out rest of the params
    QueryParams req = new QueryParams();
    req.setApiFunction(FUNCTION);
    req.setSymbol(this.formatTickerSymbol(tickerSymbol));

    return this.query(responseClass, req);
  }
}
