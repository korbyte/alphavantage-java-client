package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.opencsv.CSVParser;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ListingStatusApi extends AlphaVantageApi {
  public ListingStatusApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public void get(ListingStatusParams params) throws URISyntaxException, IOException {
    String data = this.query(params);
    CSVParser parser = new CSVParser();

    System.out.println(data);
  }
}
