package com.korbyte.alphavantage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Data
public abstract class AlphaVantageApi {

  @Getter(value = AccessLevel.PRIVATE)
  private final AlphaVantageConfig config;

  @Getter(value = AccessLevel.PRIVATE)
  private final OkHttpClient client;

  public AlphaVantageApi(AlphaVantageConfig config, OkHttpClient client) {
    this.config = config;
    this.client = client;
  }

  public String query(Object parameters) throws URISyntaxException, IOException {
    Map<String, String> mappedParameters = mapParameters(parameters);
    injectApiKey(mappedParameters);
    URI uri = buildFullURI(mappedParameters);
    System.out.println(uri); //TODO remove this
    return request(uri);
  }

  private String request(URI uri) throws IOException {
    Request request = new Request.Builder()
      .url(uri.toString())
      .build();
    String data = null;
    try (Response response = this.client.newCall(request).execute()) {
      ResponseBody body = response.body();
      if (body != null) {
        data = body.string();
      }
    }
    return data;
  }

  private void injectApiKey(Map<String, String> mappedParameters) {
    String apikey = mappedParameters.get("apikey");
    if (apikey == null || apikey.isEmpty()) mappedParameters.put("apikey", this.config.getApiKey());
  }

  private URI buildFullURI(Map<String, String> paramsList) throws URISyntaxException {
    URIBuilder builder = new URIBuilder();
    builder.setScheme(this.config.getProtocol());
    builder.setHost(this.config.getHost());
    builder.setPath(this.config.getPath());
    for (String key : paramsList.keySet()) {
      builder.addParameter(key, paramsList.get(key));
    }
    return builder.build();
  }

  private Map<String, String> mapParameters(Object obj) {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.convertValue(obj, new TypeReference<>() {
    });
  }
}
