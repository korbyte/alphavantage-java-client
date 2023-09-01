package com.korbyte.alphavantage.fundamental.listing_status.models;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@JsonPropertyOrder({"symbol", "name", "exchange", "assetType", "ipoDate", "delistingDate", "status"})
public class StockStatus {
  private String symbol;
  private String name;
  private String exchange;
  private String assetType;
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime ipoDate;
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime delistingDate;
  private String status;
}
