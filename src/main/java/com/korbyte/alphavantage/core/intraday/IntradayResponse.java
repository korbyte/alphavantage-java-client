package com.korbyte.alphavantage.core.intraday;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.core.intraday.models.IntradayMetadata;
import com.korbyte.alphavantage.core.intraday.models.IntradayPositionData;
import com.korbyte.alphavantage.util.date_time_deserializers.BaseZonedDateTimeBaseDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class IntradayResponse {

  @JsonProperty("Meta Data")
  IntradayMetadata metadata;

  @JsonIgnore
  Map<ZonedDateTime, IntradayPositionData> timeSeriesIntraday;

  @JsonAnySetter
  public void setDynamicField(String key, Map<String, IntradayPositionData> list) {
    Map<ZonedDateTime, IntradayPositionData> dataMap = null;
    if(key.contains("Time Series")){
      dataMap = new HashMap<>();
      for(String date : list.keySet()){
        ZonedDateTime zonedDateTime = BaseZonedDateTimeBaseDeserializer.deserialize(date, "America/New_York");
        dataMap.put(zonedDateTime, list.get(date));
      }

    }
    this.timeSeriesIntraday = dataMap;
  }
}
