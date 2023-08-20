package com.korbyte.alphavantage.core.intraday;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class IntradayResponse {

  @JsonProperty("Meta Data")
  IntradayMetadata metadata;

  Map<String, IntradayPositionData> timeSeries;

  @JsonAnySetter
  public void setDynamicField(String key, Map<String, IntradayPositionData> value) {
    this.timeSeries = value;
  }
}
