package com.korbyte.alphavantage.core.daily.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BaseMetadata;
import com.korbyte.alphavantage.types.OutputSize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class DailyMetadata extends BaseMetadata {
  @JsonProperty(value = "4. Output Size")
  private OutputSize outputSize;

  @JsonProperty(value = "5. Time Zone")
  private String timeZone;
}
