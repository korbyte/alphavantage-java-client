package com.korbyte.alphavantage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korbyte.alphavantage.models.QueryParams;
import okhttp3.*;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class AlphaVantageClient {

  protected final AlphaVantageConfig config;

  private final OkHttpClient client;

  /**
   * Constructor
   *
   * @param config AlphaVantageConfig object
   */
  public AlphaVantageClient(AlphaVantageConfig config) {
    this.config = config;
    this.client = new OkHttpClient();
  }

  //====================================================================================================================
  // Private Methods
  //====================================================================================================================

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
//        case "x-download" -> handleDownload();
        case "json" -> data = handleJSON(tClass, body);
      }
    }
    return data;
  }

//  private <T> T handleDownload(Class<T> tClass, ResponseBody body) {
//
//  }

  private <T> T handleJSON(Class<T> tClass, ResponseBody body) throws IOException {
    String bodyString = body.string();
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(bodyString, tClass);
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

  /**
   * Build the URI for the query
   * @param params QueryParams object
   * @return URI
   * @throws URISyntaxException If the URI is invalid
   */
  private URI buildQueryURI(QueryParams params) throws URISyntaxException {
    Map<String, String> paramsList = new HashMap<>();

    paramsList.put("apikey", this.config.getApiKey());
    paramsList.put("function", params.getApiFunction().toString());
    paramsList.put("symbol", params.getSymbol());
    paramsList.put("outputsize", params.getOutputsize().toString());


    return buildFullURI(paramsList);
  }

  //====================================================================================================================
  // Public Methods
  //====================================================================================================================

  /**
   * Query the API
   *
   * @param mappedClass The class to map the body response to
   * @param params      QueryParams object
   * @param <T>         The mapped class
   * @return The mapped class
   * @throws URISyntaxException If the URI is invalid
   * @throws IOException        If there is an error with the request
   */
  public <T> T query(Class<T> mappedClass, QueryParams params) throws URISyntaxException, IOException {
    URI uri = buildQueryURI(params);
    return request(mappedClass, uri);
  }

  /**
   * Format the ticker symbol
   * - Trims whitespace and makes it uppercase
   * TODO: 8/15/2023 Add more formatting cleanup
   *
   * @param tickerSymbol The ticker symbol to format
   * @return The formatted ticker symbol
   */
  public String formatTickerSymbol(String tickerSymbol) {
    return tickerSymbol.toUpperCase().trim();
  }
}
