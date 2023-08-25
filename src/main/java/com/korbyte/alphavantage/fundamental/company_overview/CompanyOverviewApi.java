package com.korbyte.alphavantage.fundamental.company_overview;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class CompanyOverviewApi extends AlphaVantageApi {
  public CompanyOverviewApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public CompanyOverviewResponse get(CompanyOverviewParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    return this.parseResponse(data, CompanyOverviewResponse.class);
  }
}
