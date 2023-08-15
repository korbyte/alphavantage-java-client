package com.korbyte;

import com.korbyte.models.Function;
import com.korbyte.models.QueryParams;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AlphaVantageClient {

  private final AlphaVantageConfig config;

  private final OkHttpClient client;

  public AlphaVantageClient(AlphaVantageConfig config) {
    this.config = config;
    this.client = new OkHttpClient();
  }

  public AlphaVantageConfig getConfig() {
    return this.config;
  }

  public String query(QueryParams params) throws IOException, URISyntaxException {
    URI uri = buildQueryURI(params);
    Request request = new Request.Builder()
      .url(uri.toString())
      .build();
    try (Response response = this.client.newCall(request).execute()) {
      return response.body().string();
    }
  }

  public void getDaily(String symbol) throws IOException, URISyntaxException {
    //TODO remove this method, the object is to make this a map
    QueryParams params = queryParams();
    params.setFunction(Function.TIME_SERIES_DAILY);
    params.setSymbol(symbol);
    query(params);
  }

  private QueryParams queryParams() {
    QueryParams params = new QueryParams();
    params.setApiKey(this.config.getApiKey());
    return params;
  }

  private URI buildQueryURI(QueryParams params) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder();
    uriBuilder.setPath(this.config.getPath());
    uriBuilder
      .setScheme(this.config.getProtocol())
      .setHost(this.config.getHost())
      .setPath(this.config.getPath())
      .addParameter("symbol", params.getSymbol())
      .addParameter("function", params.getFunction().toString())
      .addParameter("apiKey", params.getApiKey());
    return uriBuilder.build();
  }
}
