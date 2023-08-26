package com.korbyte.alphavantage.economic;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.economic.gdp.GdpApi;
import com.korbyte.alphavantage.economic.gdp_per_capita.GdpPerCapitaApi;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

/**
 * Economic API
 *
 * @see <a href="https://www.alphavantage.co/documentation/#economic-indicators">Economic Indicators</a>
 */
@Getter
@Accessors(fluent = true, chain = true)
public class EconomicApi extends AlphaVantageApi {

  private final GdpApi gdp;
  private final GdpPerCapitaApi gdpPerCapita;

  public EconomicApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
    this.gdp = new GdpApi(config, client);
    this.gdpPerCapita = new GdpPerCapitaApi(config, client);
  }

}
