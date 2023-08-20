package com.korbyte.alphavantage.economic;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.economic.gdp.GdpApi;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true, chain = true)
public class EconomicApi extends AlphaVantageApi {

    private final GdpApi gdp;

    public EconomicApi(AlphaVantageConfig config, OkHttpClient client) {
      super(config, client);
      this.gdp = new GdpApi(config, client);
    }

}
