package com.korbyte.alphavantage.fundamental;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.fundamental.company_overview.CompanyOverviewApi;
import com.korbyte.alphavantage.fundamental.listing_status.ListingStatusApi;
import lombok.Getter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;

@Getter
@Accessors(fluent = true, chain = true)
public class FundamentalApi extends AlphaVantageApi {

  private final ListingStatusApi listingStatus;
  private final CompanyOverviewApi companyOverview;

  public FundamentalApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
    this.listingStatus = new ListingStatusApi(config, client);
    this.companyOverview = new CompanyOverviewApi(config, client);
  }
}
