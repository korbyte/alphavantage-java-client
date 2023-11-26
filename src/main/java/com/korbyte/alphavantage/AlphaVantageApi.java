package com.korbyte.alphavantage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.error.ApiErrorType;
import com.korbyte.alphavantage.error.ApiResponseError;
import com.korbyte.alphavantage.error.ApiResponseException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.hc.core5.net.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Alpha Vantage API
 */
@Data
public abstract class AlphaVantageApi {

  private final ObjectMapper objectMapper;
  @Getter(value = AccessLevel.PRIVATE)
  private final AlphaVantageConfig config;
  @Getter(value = AccessLevel.PRIVATE)
  private final OkHttpClient client;

  public AlphaVantageApi(AlphaVantageConfig config, OkHttpClient client) {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.findAndRegisterModules();
    this.config = config;
    this.client = client;
  }

  /**
   * Query Alpha Vantage API into string response
   *
   * @param parameters Object
   * @return String
   * @throws URISyntaxException URL is invalid
   * @throws IOException        Network error
   */
  public String query(Object parameters) throws URISyntaxException, IOException {
    Map<String, String> mappedParameters = mapParameters(parameters);
    injectApiKey(mappedParameters);
    URI uri = buildFullURI(mappedParameters);
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
    return objectMapper.convertValue(obj, new TypeReference<>() {
    });
  }

  /**
   * Parse the error response into an exception
   *
   * @param rawResponse The raw response from the API
   * @return The parsed exception
   * @throws JsonProcessingException If the response cannot be parsed
   */
  protected ApiResponseException parseError(Exception e, String rawResponse) throws JsonProcessingException {
    ObjectMapper errorMapper = new ObjectMapper();
    errorMapper.findAndRegisterModules();
    errorMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    ApiResponseError responseError = errorMapper.readValue(rawResponse, ApiResponseError.class);
    if (responseError.getMaxCallError() != null) {
      return new ApiResponseException(responseError.getMaxCallError(), responseError, ApiErrorType.MAX_CALL_ERROR);
    } else if (responseError.getMaxVolumeError() != null) {
      return new ApiResponseException(responseError.getMaxVolumeError(), responseError, ApiErrorType.MAX_VOLUME_ERROR);
    } else if (responseError.getInvalidApiCall() != null) {
      return new ApiResponseException(responseError.getInvalidApiCall(), responseError, ApiErrorType.INVALID_API_CALL);
    } else {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * Parse the response into the given class
   *
   * @param rawResponse The raw response from the API
   * @param tClass      The class to parse the response into
   * @param <T>         The type of the response
   * @return The parsed response
   * @throws ApiResponseException    If the response is an error
   * @throws JsonProcessingException If the response cannot be parsed
   */
  protected <T> T parseResponse(String rawResponse, Class<T> tClass) throws ApiResponseException, JsonProcessingException {
    // optimistically, try to parse the response
    // else try to parse the response as an error
    try {
      return objectMapper.readValue(rawResponse, tClass);
    } catch (Exception e) {
      throw parseError(e, rawResponse);
    }
  }

}
