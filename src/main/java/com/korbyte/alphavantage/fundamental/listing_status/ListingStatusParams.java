package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.params.ApiFunction;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ListingStatusParams {
  private ApiFunction function = ApiFunction.LISTING_STATUS;
  private Date date;
  private String state;
}
