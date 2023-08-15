package com.korbyte;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.models.QueryParams;
import lombok.Data;
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

  public <T> T query(Class<T> mappedClass, QueryParams params) throws URISyntaxException, IOException {
    params.setApikey(this.config.getApiKey());
    URI uri = buildQueryURI(params);
    return request(mappedClass, uri);
  }

  private <T> T request(Class<T> tClass, URI uri) throws IOException {
    Request request = new Request.Builder()
            .url(uri.toString())
            .build();
    T data = null;
    try (Response response = this.client.newCall(request).execute()) {
      if (response.body() != null) {
        String body = response.body().string();
        ObjectMapper mapper = new ObjectMapper();
        data = mapper.readValue(body, tClass);
      }
    }
    return data;
  }

  private URI buildQueryURI(QueryParams params) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder();
    uriBuilder.setPath(this.config.getPath());
    uriBuilder.setScheme(this.config.getProtocol())
            .setHost(this.config.getHost())
            .setPath(this.config.getPath())
            .addParameter("symbol", params.getSymbol())
            .addParameter("function", params.getFunction().toString())
            .addParameter("apikey", params.getApikey());
    return uriBuilder.build();
  }
}
