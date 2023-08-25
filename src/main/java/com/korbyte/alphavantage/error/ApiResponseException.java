package com.korbyte.alphavantage.error;

import lombok.Getter;

@Getter
public class ApiResponseException extends Exception {

  private final ApiResponseError error;

  public ApiResponseException(String message, ApiResponseError error) {
    super(message);
    this.error = error;
  }
}
