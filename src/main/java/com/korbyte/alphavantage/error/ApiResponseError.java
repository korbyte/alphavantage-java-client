package com.korbyte.alphavantage.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class ApiResponseError {
  @JsonProperty(value = "Note")
  @Setter(AccessLevel.NONE)
  private String error;
}
