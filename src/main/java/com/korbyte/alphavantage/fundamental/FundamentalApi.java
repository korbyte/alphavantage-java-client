package com.korbyte.alphavantage.fundamental;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.fundamental.listing_status.ListingStatusApi;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true, chain = true)
public class FundamentalApi extends AlphaVantageApi {

  private final ListingStatusApi listingStatus;

  public FundamentalApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
    this.listingStatus = new ListingStatusApi(config, client);
  }
}
