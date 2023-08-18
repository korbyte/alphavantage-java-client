package com.korbyte.alphavantage.fundamental.listing_status;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ListingStatusResponse {
  private String symbol;
  private String name;
  private String exchange;
  private String assetType;
  private Date iopDate;
  private Date delistingDate;
  private String status;

  public ListingStatusResponse() {
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
  public ListingStatusResponse(String symbol, String name, String exchange, String assetType, Date iopDate, Date delistingDate, String status) {
    this.symbol = symbol;
    this.name = name;
    this.exchange = exchange;
    this.assetType = assetType;
    this.iopDate = iopDate;
    this.delistingDate = delistingDate;
    this.status = status;
  }
}
