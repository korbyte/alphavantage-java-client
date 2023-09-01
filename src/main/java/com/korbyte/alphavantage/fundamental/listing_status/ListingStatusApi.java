package com.korbyte.alphavantage.fundamental.listing_status;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.korbyte.alphavantage.AlphaVantageApi;
import com.korbyte.alphavantage.AlphaVantageConfig;
import com.korbyte.alphavantage.fundamental.listing_status.models.StockStatus;
import com.korbyte.alphavantage.util.date_time_deserializers.BaseZonedDateTimeDeserializer;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;
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
   */
  public ListingStatusResponse get(ListingStatusParams params)
    throws URISyntaxException, IOException {
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
   * @throws IOException            Network error
   */
  private List<StockStatus> parseCSV(String data) throws IOException {
    List<StockStatus> stockStatusResponse = new ArrayList<>();
    CsvMapper mapper = new CsvMapper();
    mapper.findAndRegisterModules();
    CsvSchema headerSchema = CsvSchema.emptySchema().withHeader();

    try (MappingIterator<StockStatus> it = mapper
      .readerFor(StockStatus.class)
      .with(headerSchema)
      .readValues(data)) {
      while (it.hasNext()) {
        StockStatus stockStatus = it.next();
        stockStatusResponse.add(stockStatus);
      }
    }

    return stockStatusResponse;
  }
}
