package com.korbyte.alphavantage.fundamental.listing_status;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.korbyte.alphavantage.types.ApiFunction;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class ListingStatusParams {
  @Setter(AccessLevel.NONE)
  private ApiFunction function = ApiFunction.LISTING_STATUS;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate date = LocalDate.now();
  private String state = "active";
}
