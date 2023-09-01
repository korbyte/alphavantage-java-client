package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.fundamental.listing_status.models.StockStatus;

import java.util.List;
import lombok.Data;

@Data
public class ListingStatusResponse {

  List<StockStatus> statusList;
}
