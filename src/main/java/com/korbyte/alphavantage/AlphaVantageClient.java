package com.korbyte.alphavantage;

import com.korbyte.alphavantage.core.CoreApi;
import com.korbyte.alphavantage.fundamental.FundamentalApi;
import lombok.Data;
import lombok.experimental.Accessors;
import okhttp3.*;


@Data
@Accessors(fluent = true, chain = true)
public class AlphaVantageClient {

  private final CoreApi core;
  private final FundamentalApi fundamental;

  /**
   * Constructor
   *
   * @param config AlphaVantageConfig object
   */
  public AlphaVantageClient(AlphaVantageConfig config) {
    OkHttpClient client = new OkHttpClient();
    this.core = new CoreApi(config, client);
    this.fundamental = new FundamentalApi(config, client);
  }
}
