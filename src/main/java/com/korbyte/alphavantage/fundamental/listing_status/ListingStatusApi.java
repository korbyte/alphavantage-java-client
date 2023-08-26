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
   * @return List of ListingStatusResponse objects
   * @throws URISyntaxException
   * @throws IOException
   * @throws CsvValidationException
   */
  public List<ListingStatusResponse> get(ListingStatusParams params)
    throws URISyntaxException, IOException, CsvValidationException {
    String data = this.query(params);
    return parseCSV(data);
  }

  /**
   * Parse the CSV data into a list of ListingStatusResponse objects
   *
   * @param data CSV data
   * @return List of ListingStatusResponse objects
   * @throws CsvValidationException
   * @throws IOException
   */
  private List<ListingStatusResponse> parseCSV(String data) throws CsvValidationException, IOException {
    List<ListingStatusResponse> listingStatusResponses = new ArrayList<>();

    try (CSVReader reader = new CSVReader(new StringReader(data))) {
      reader.skip(1); // skip the header

      String[] line;
      while ((line = reader.readNext()) != null) {
        Date ipoDate = parseDateString(line[4]);
        Date delistDate = parseDateString(line[5]);

        ListingStatusResponse listingStatusResponse = new ListingStatusResponse(
          line[0], // symbol
          line[1], // name
          line[2], // exchange
          line[3], // assetType
          ipoDate,
          delistDate,
          line[6]  // status
        );

        listingStatusResponses.add(listingStatusResponse);
      }
    }

    return listingStatusResponses;
  }


  /**
   * Parse a date string into a Date object
   *
   * @param dateString Date string
   * @return Date object
   */
  private Date parseDateString(String dateString) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = sdf.parse(dateString);
    } catch (ParseException ignored) {
    }
    return date;
  }
}
