package com.korbyte.alphavantage.core.global_market_status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class GlobalMarketStatusApi extends AlphaVantageApi {
  public GlobalMarketStatusApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * This API returns market status and trading hours for a given market.
   *
   * @param params GlobalMarketStatusParams object
   * @return GlobalMarketStatusResponse
   */
  public GlobalMarketStatusResponse get(GlobalMarketStatusParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, GlobalMarketStatusResponse.class);
  }
}
