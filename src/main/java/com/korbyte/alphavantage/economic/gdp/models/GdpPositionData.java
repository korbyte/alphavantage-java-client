package com.korbyte.alphavantage.economic.gdp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * GDP position data
 */
@Data
public class GdpPositionData {
  @JsonProperty("date")
  private Date date;
  @JsonProperty("value")
  private Float value;
}
