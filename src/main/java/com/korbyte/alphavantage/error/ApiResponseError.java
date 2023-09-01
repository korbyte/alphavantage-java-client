package com.korbyte.alphavantage.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class ApiResponseError {
  /**
   * Error response from the API
   * <p>
   *   "Note": "Thank you for using Alpha Vantage! Our standard API call frequency is 5 calls per minute and 500 calls per day. Please visit https://www.alphavantage.co/premium/ if you would like to target a higher API call frequency."
   * </p>
   */
  @JsonProperty(value = "Note")
  @Setter(AccessLevel.NONE)
  private String maxCallError;

  /**
   * Over use error response from the API
   * <p>
   *  "Information": "Thank you for using Alpha Vantage! Please contact premium@alphavantage.co if you are targeting a higher API call volume."
   * </p>
   */
  @JsonProperty(value = "Information")
  @Setter(AccessLevel.NONE)
  private String maxVolumeError;

  /**
   * Invalid API call error response from the API
   * <p>
   *   "Error Message": "Invalid API call. Please retry or visit the documentation (https://www.alphavantage.co/documentation/) for [the api call]."
   * </p>
   */
  @JsonProperty(value = "Error Message")
  @Setter(AccessLevel.NONE)
  private String invalidApiCall;
}
