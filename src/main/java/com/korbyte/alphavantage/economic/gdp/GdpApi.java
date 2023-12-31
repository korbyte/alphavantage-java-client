package com.korbyte.alphavantage.economic.gdp;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * GDP per capita is a measure of country's gross domestic product.
 *
 * @see <a href="https://www.alphavantage.co/documentation/#real-gdp">AlphaVantage Documentation</a>
 */
public class GdpApi extends AlphaVantageApi {

  public GdpApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * Get GDP data
   *
   * @param params The parameters for the GDP data request
   * @return GDP data
   * @throws URISyntaxException   URL is invalid
   * @throws IOException          Network error
   * @throws ApiResponseException API response error
   */
  public GdpResponse get(GdpParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, GdpResponse.class);
  }
}
