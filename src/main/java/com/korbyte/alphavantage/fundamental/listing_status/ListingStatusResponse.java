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
}
