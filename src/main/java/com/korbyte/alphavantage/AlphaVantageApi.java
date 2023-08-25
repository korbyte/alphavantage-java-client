package com.korbyte.alphavantage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.base.ApiResponse;
import com.korbyte.alphavantage.error.ApiResponseError;
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

/**
 * Alpha Vantage API
 */
@Data
public abstract class AlphaVantageApi {

  @Getter(value = AccessLevel.PRIVATE)
  private final AlphaVantageConfig config;

  @Getter(value = AccessLevel.PRIVATE)
  private final OkHttpClient client;

  private static final ObjectMapper MAPPER = new ObjectMapper();

  public AlphaVantageApi(AlphaVantageConfig config, OkHttpClient client) {
    this.config = config;
    this.client = client;
  }

  /**
   * Query Alpha Vantage API into string response
   * @param parameters Object
   * @return String
   * @throws URISyntaxException
   * @throws IOException
   */
  public String query(Object parameters) throws URISyntaxException, IOException {
    Map<String, String> mappedParameters = mapParameters(parameters);
    injectApiKey(mappedParameters);
    URI uri = buildFullURI(mappedParameters);
    System.out.println(uri.toString());
    return request(uri);
  }

  private String request(URI uri) throws IOException {
    Request request = new Request.Builder()
      .url(uri.toString())
      .build();

    try (Response response = this.client.newCall(request).execute()) {
      ResponseBody body = response.body();
      return body != null ? body.string() : null;
    }
  }

  private void injectApiKey(Map<String, String> mappedParameters) {
    mappedParameters.putIfAbsent("apikey", this.config.getApiKey());
  }

  private URI buildFullURI(Map<String, String> paramsList) throws URISyntaxException {
    URIBuilder builder = new URIBuilder();
    builder.setScheme(this.config.getProtocol());
    builder.setHost(this.config.getHost());
    builder.setPath(this.config.getPath());

    for (Map.Entry<String, String> entry : paramsList.entrySet()) {
      String param = entry.getValue();
      if (param != null && !param.isEmpty()) {
        builder.addParameter(entry.getKey(), param);
      }
    }
    return builder.build();
  }

  private Map<String, String> mapParameters(Object obj) {
    return MAPPER.convertValue(obj, new TypeReference<>() {});
  }


  protected <T> T parseResponse(String rawResponse, Class<T> tClass) throws JsonProcessingException, ApiResponseError {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    ApiResponse<T> apiResponse = objectMapper.readValue(rawResponse, objectMapper.getTypeFactory().constructParametricType(ApiResponse.class, tClass));

    if (apiResponse.getError() != null) {
      throw new ApiResponseError(apiResponse.getError());
    } else {
      return apiResponse.getData();
    }
  }

}
