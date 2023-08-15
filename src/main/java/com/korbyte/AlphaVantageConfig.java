package com.korbyte;

import lombok.Data;

@Data
public class AlphaVantageConfig {
  private String apiKey;
  private String protocol = "https";
  private String host = "www.alphavantage.co";
  private String path = "/query";
}
