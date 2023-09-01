package com.korbyte.alphavantage.error;

import lombok.Getter;


@Getter
public class ApiResponseException extends Exception {

  private final ApiResponseError error;
  private final ApiErrorType apiErrorType;

  public ApiResponseException(String message, ApiResponseError error, ApiErrorType apiErrorType) {
    super(message);
    this.error = error;
    this.apiErrorType = apiErrorType;
  }
}
