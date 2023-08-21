package com.korbyte.alphavantage.core.intraday.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BaseMetadata;
import com.korbyte.alphavantage.types.OutputSize;
import com.korbyte.alphavantage.types.interval_models.MinIntervalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class IntradayMetadata extends BaseMetadata {

  @JsonProperty(value = "4. Interval")
  private MinIntervalType interval;

  @JsonProperty(value = "5. Output Size")
  private OutputSize outputSize;

  @JsonProperty(value = "6. Time Zone")
  private String timezone;
}
