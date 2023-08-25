package com.korbyte.alphavantage.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class ApiResponse<T> {
  private T data;

  @JsonProperty(value = "Note")
  @Setter(AccessLevel.NONE)
  private String error;
}
