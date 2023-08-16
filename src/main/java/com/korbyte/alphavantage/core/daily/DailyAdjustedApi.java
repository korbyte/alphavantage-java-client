package com.korbyte.alphavantage.core.daily;

import com.korbyte.alphavantage.AlphaVantageClient;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.base.ApiFunction;
import com.korbyte.alphavantage.base.ApiInterface;
import com.korbyte.alphavantage.models.queryparams.QueryParams;
import com.korbyte.alphavantage.models.core.daily.DailyAdjustedResponse;

import java.io.IOException;
import java.net.URISyntaxException;

public class DailyAdjustedApi extends AlphaVantageClient implements ApiInterface<String, DailyAdjustedResponse> {

  private static final ApiFunction FUNCTION = ApiFunction.DAILY;

  private final Class<DailyAdjustedResponse> responseClass = DailyAdjustedResponse.class;

  public DailyAdjustedApi(AlphaVantageConfig config) {
    super(config);
  }

  public DailyAdjustedResponse get(String tickerSymbol) throws URISyntaxException, IOException {
    //todo: figure out rest of the params
    QueryParams req = new QueryParams();
    req.setApiFunction(FUNCTION);
    req.setSymbol(this.formatTickerSymbol(tickerSymbol));

    return this.query(responseClass, req);
  }
}
