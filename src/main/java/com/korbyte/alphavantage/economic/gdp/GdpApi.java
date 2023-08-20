package com.korbyte.alphavantage.economic.gdp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * GDP per capita is a measure of country's gross domestic product.
 * @see <a href="https://www.alphavantage.co/documentation/#real-gdp">AlphaVantage Documentation</a>
 */
public class GdpApi extends AlphaVantageApi {

  public GdpApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  /**
   * Get GDP data
   * @param params The parameters for the GDP data request
   * @return GDP data
   * @throws URISyntaxException
   * @throws IOException
   */
  public GdpResponse get(GdpParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, GdpResponse.class);
  }
}
