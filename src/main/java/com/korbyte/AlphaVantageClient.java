package com.korbyte;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.models.QueryParams;
import lombok.Data;
import okhttp3.*;
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
      ResponseBody body = response.body();
      if (body != null) {
        data = handleResponseTypes(tClass, body);
      }
    }
    return data;
  }

  private <T> T handleResponseTypes(Class<T> tClass, ResponseBody body) throws IOException {
    T data = null;
    MediaType mediaType = body.contentType();
    if (mediaType != null) {
      switch (mediaType.subtype()) {
        case "x-download" -> handleDownload();
        case "json" -> data = handleJSON(tClass, body);
      }
    }
    return data;
  }

  private <T> T handleDownload(Class<T> tClass, ResponseBody body) {

  }

  private <T> T handleJSON(Class<T> tClass, ResponseBody body) throws IOException {
    String bodyString = body.string();
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(bodyString, tClass);
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
