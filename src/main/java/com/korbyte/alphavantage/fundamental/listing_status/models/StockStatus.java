package com.korbyte.alphavantage.fundamental.listing_status.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class StockStatus {
  private String symbol;
  private String name;
  private String exchange;
  private String assetType;
  private ZonedDateTime iopDate;
  private ZonedDateTime delistingDate;
  private String status;

  public StockStatus() {
  }

  /**
   * Full constructor
   *
   * @param symbol
   * @param name
   * @param exchange
   * @param assetType
   * @param iopDate
   * @param delistingDate
   * @param status
   */
  public StockStatus(String symbol, String name, String exchange, String assetType, ZonedDateTime iopDate, ZonedDateTime delistingDate, String status) {
    this.symbol = symbol;
    this.name = name;
    this.exchange = exchange;
    this.assetType = assetType;
    this.iopDate = iopDate;
    this.delistingDate = delistingDate;
    this.status = status;
  }
}
