package com.korbyte.alphavantage.models.queryparams;

public enum DataType {
  JSON("json"),
  CSV("csv");

  private final String type;

  DataType(String type) {
    this.type = type;
  }

  public String valueOf() {
    return this.type;
  }
}
