package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.types.ApiFunction;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ListingStatusParams {
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.LISTING_STATUS;
  private Date date = new Date();
  private String state = "active";
}
