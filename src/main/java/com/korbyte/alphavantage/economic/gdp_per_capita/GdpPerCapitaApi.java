package com.korbyte.alphavantage.economic.gdp_per_capita;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.economic.gdp.GdpResponse;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * GDP per capita is a measure of country's gross domestic product by person.
 * @see <a href="https://www.alphavantage.co/documentation/#real-gdp-per-capita">AlphaVantage Documentation</a>
 */
public class GdpPerCapitaApi extends AlphaVantageApi {

  public GdpPerCapitaApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public GdpResponse get(GdpPerCapitaParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, GdpResponse.class);
  }
}
