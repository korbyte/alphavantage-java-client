package com.korbyte.alphavantage.core.intraday;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.intraday.models.IntradayMetadata;
import com.korbyte.alphavantage.core.intraday.models.IntradayPositionData;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class IntradayResponse {

  @JsonProperty("Meta Data")
  IntradayMetadata metadata;

  Map<Date, IntradayPositionData> timeSeriesIntraday;

  @JsonAnySetter
  public void setDynamicField(String key, Map<Date, IntradayPositionData> value) {
    this.timeSeriesIntraday = value;
  }
}
