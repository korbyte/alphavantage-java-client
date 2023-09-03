package com.korbyte.alphavantage.fundamental.company_overview;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.error.ApiResponseException;
import com.korbyte.alphavantage.fundamental.company_overview.models.CompanyOverview;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class CompanyOverviewApi extends AlphaVantageApi {
  public CompanyOverviewApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public CompanyOverviewResponse get(CompanyOverviewParams params) throws URISyntaxException, IOException, ApiResponseException {
    String data = this.query(params);
    CompanyOverview overview = this.parseResponse(data, CompanyOverview.class);
    CompanyOverviewResponse response = new CompanyOverviewResponse();
    response.setCompanyOverview(overview);
    return response;
  }
}
