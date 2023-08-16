package com.korbyte.alphavantage.models.queryparams;

public enum OutputSize {
  COMPACT("compact"),
  FULL("full");

  private final String outputSize;

  OutputSize(String outputSize) {
    this.outputSize = outputSize;
  }

  public String valueOf() {
    return this.outputSize;
  }
}
