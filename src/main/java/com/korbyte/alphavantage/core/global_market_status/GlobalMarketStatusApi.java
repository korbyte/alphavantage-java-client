package com.korbyte.alphavantage.core.global_market_status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.core.global_market_status.models.GlobalMarketStatusParams;
import com.korbyte.alphavantage.core.global_market_status.models.GlobalMarketStatusResponse;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class GlobalMarketStatusApi extends AlphaVantageApi {
  public GlobalMarketStatusApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * This API returns market status and trading hours for a given market.
   * @param params GlobalMarketStatusParams object
   * @return GlobalMarketStatusResponse
   * @throws URISyntaxException
   * @throws IOException
   */
  public GlobalMarketStatusResponse get(GlobalMarketStatusParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, GlobalMarketStatusResponse.class);
  }
}
