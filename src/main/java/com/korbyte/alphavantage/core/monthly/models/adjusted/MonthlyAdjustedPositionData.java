package com.korbyte.alphavantage.core.monthly.models.adjusted;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.alphavantage.baseModels.BasePositionData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MonthlyAdjustedPositionData extends BasePositionData {
  @JsonProperty(required = true, value = "5. adjusted close")
  private Float adjustedClose;

  @JsonProperty(required = true, value = "6. volume")
  private Integer volume;

  @JsonProperty(required = true, value = "7. dividend amount")
  private Float dividendAmount;
}
