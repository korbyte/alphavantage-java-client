package com.korbyte.alphavantage.core.monthly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.base.BaseMetadata;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MonthlyMetadata extends BaseMetadata {

  @JsonProperty(value = "4. Time Zone")
  private String timeZone;
}
