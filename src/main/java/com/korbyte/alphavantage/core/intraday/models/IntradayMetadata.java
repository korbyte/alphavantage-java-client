package com.korbyte.alphavantage.core.intraday.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BaseMetadata;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class IntradayMetadata extends BaseMetadata {

  @JsonProperty(value = "4. Interval")
  private String interval;

  @JsonProperty(value = "5. Output Size")
  private String outputsize;

  @JsonProperty(value = "6. Time Zone")
  private String timezone;
}
