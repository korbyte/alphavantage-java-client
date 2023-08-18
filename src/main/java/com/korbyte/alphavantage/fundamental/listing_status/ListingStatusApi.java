package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListingStatusApi extends AlphaVantageApi {
  public ListingStatusApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  public List<ListingStatusResponse> get(ListingStatusParams params)
    throws URISyntaxException, IOException, CsvValidationException
  {
    String data = this.query(params);
    return parseCSV(data);
  }

  private List<ListingStatusResponse> parseCSV(String data) throws CsvValidationException, IOException {
    CSVReader reader = new CSVReader(new StringReader(data));
    List<ListingStatusResponse> listingStatusResponses = new ArrayList<>();

    String[] line;
    reader.skip(1);
    while ((line = reader.readNext()) != null) {
      ListingStatusResponse listingStatusResponse = new ListingStatusResponse();

      String symbol = line[0];
      String name = line[1];
      String exchange = line[2];
      String assetType = line[3];
      Date ipoDate = parseDateString(line[4]);
      Date delistDate = parseDateString(line[5]);
      String status = line[6];

      listingStatusResponse
        .setSymbol(symbol)
        .setName(name)
        .setExchange(exchange)
        .setAssetType(assetType)
        .setIopDate(ipoDate)
        .setDelistingDate(delistDate)
        .setStatus(status);
      listingStatusResponses.add(listingStatusResponse);
    }
    return listingStatusResponses;
  }

  private Date parseDateString(String dateString) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = sdf.parse(dateString);
    } catch (ParseException ignored) {}
    return date;
  }
}
