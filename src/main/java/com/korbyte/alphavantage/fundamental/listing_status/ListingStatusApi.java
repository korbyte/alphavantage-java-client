package com.korbyte.alphavantage.fundamental.listing_status;

import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.fundamental.listing_status.models.StockStatus;
import com.korbyte.alphavantage.util.date_time_deserializers.BaseZonedDateTimeDeserializer;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Listing Status API
 */
public class ListingStatusApi extends AlphaVantageApi {
  public ListingStatusApi(AlphaVantageConfig config, OkHttpClient client) {
    super(config, client);
  }

  //todo figure out what happens when rate limit is hit and this method is called on the AV side

  /**
   * Get the listing status of all securities supported by Alpha Vantage
   *
   * @param params ListingStatusParams object
   * @return List of StockStatus objects
   * @throws URISyntaxException     URL is invalid
   * @throws IOException            Network error
   * @throws CsvValidationException CSV data is invalid
   */
  public ListingStatusResponse get(ListingStatusParams params)
    throws URISyntaxException, IOException, CsvValidationException {
    String data = this.query(params);
    ListingStatusResponse response = new ListingStatusResponse();
    response.setStatusList(parseCSV(data));
    return response;
  }

  /**
   * Parse the CSV data into a list of StockStatus objects
   *
   * @param data CSV data
   * @return List of StockStatus objects
   * @throws CsvValidationException CSV data is invalid
   * @throws IOException            Network error
   */
  private List<StockStatus> parseCSV(String data) throws CsvValidationException, IOException {
    List<StockStatus> stockStatusResponse = new ArrayList<>();

    try (CSVReader reader = new CSVReader(new StringReader(data))) {
      reader.skip(1); // skip the header

      String[] line;
      while ((line = reader.readNext()) != null) {
        ZonedDateTime ipoDate = BaseZonedDateTimeDeserializer.deserialize(line[4]);
        ZonedDateTime delistDate = BaseZonedDateTimeDeserializer.deserialize(line[5]);

        StockStatus stockStatus = new StockStatus(
          line[0], // symbol
          line[1], // name
          line[2], // exchange
          line[3], // assetType
          ipoDate,
          delistDate,
          line[6]  // status
        );

        stockStatusResponse.add(stockStatus);
      }
    }

    return stockStatusResponse;
  }
}
