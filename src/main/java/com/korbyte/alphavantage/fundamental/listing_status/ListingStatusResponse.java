package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.fundamental.listing_status.models.StockStatus;
import lombok.Data;

import java.util.List;

@Data
public class ListingStatusResponse {

  List<StockStatus> statusList;
}
