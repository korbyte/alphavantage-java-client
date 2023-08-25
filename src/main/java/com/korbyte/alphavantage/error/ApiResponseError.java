package com.korbyte.alphavantage.error;

public class ApiResponseError extends Exception {

  public ApiResponseError(String message) {
    super(message);
  }

}
