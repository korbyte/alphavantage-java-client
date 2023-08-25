package com.korbyte.alphavantage;

import com.korbyte.alphavantage.core.CoreApi;
import com.korbyte.alphavantage.economic.EconomicApi;
import com.korbyte.alphavantage.fundamental.FundamentalApi;
import com.korbyte.alphavantage.technical.TechnicalApi;
import lombok.Data;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;


@Data
@Accessors(fluent = true, chain = true)
public class AlphaVantageClient {

  private final CoreApi core;
  private final EconomicApi economic;
  private final FundamentalApi fundamental;
  private final TechnicalApi technical;

  /**
   * Constructor
   *
   * @param config AlphaVantageConfig object
   */
  public AlphaVantageClient(AlphaVantageConfig config) {
    OkHttpClient client = new OkHttpClient();
    this.core = new CoreApi(config, client);
    this.fundamental = new FundamentalApi(config, client);
    this.economic = new EconomicApi(config, client);
    this.technical = new TechnicalApi(config, client);
  }
}
