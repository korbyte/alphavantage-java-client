package com.korbyte.alphavantage.technical.rsi;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
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
   * @return RsiResponse data
   * @throws URISyntaxException URL is invalid
   * @throws IOException Network error
   * @throws ApiResponseException API response error
   */
  public RsiResponse get(RsiParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, RsiResponse.class);
  }
}
