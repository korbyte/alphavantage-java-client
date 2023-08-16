package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.params.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class ListingStatusParams extends BaseParams {
  private Date date;
  private String state;
}
