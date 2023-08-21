package com.korbyte.alphavantage.technical.rsi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * RSI API
 * @see <a href="https://www.alphavantage.co/documentation/#rsi">RSI Documentation</a>
 */
public class RsiApi extends AlphaVantageApi  {

  public RsiApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * Get RSI data
   * @param params RsiParams
   * @return RsiResponse
   * @throws Exception exception
   */
  public RsiResponse get(RsiParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, RsiResponse.class);
  }
}
