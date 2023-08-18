package com.korbyte.alphavantage.fundamental.company_overview;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class CompanyOverviewApi extends AlphaVantageApi {
  public CompanyOverviewApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public CompanyOverviewResponse get(CompanyOverviewParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    return new ObjectMapper().readValue(data, CompanyOverviewResponse.class);
  }
}
