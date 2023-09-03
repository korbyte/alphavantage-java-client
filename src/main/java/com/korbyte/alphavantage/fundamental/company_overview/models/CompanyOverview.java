package com.korbyte.alphavantage.fundamental.company_overview.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.korbyte.alphavantage.util.date_time_deserializers.EasternZonedDateDeserializer;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CompanyOverview {
  @JsonProperty("Symbol")
  private String symbol;

  @JsonProperty("AssetType")
  private String assetType;

  @JsonProperty("Name")
  private String name;

  @JsonProperty("Description")
  private String description;

  @JsonProperty("CIK")
  private Integer cik;

  @JsonProperty("Exchange")
  private String exchange;

  @JsonProperty("Currency")
  private String currency;

  @JsonProperty("Country")
  private String country;

  @JsonProperty("Sector")
  private String sector;

  @JsonProperty("Industry")
  private String industry;

  @JsonProperty("Address")
  private String address;

  @JsonProperty("FiscalYearEnd")
  private String fiscalYearEnd;

  @JsonProperty("LatestQuarter")
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime latestQuarter;

  @JsonProperty("MarketCapitalization")
  private Double marketCapitalization;

  @JsonProperty("EBITDA")
  private Double ebitda;

  @JsonProperty("PERatio")
  private Float peRatio;

  @JsonProperty("PEGRatio")
  private Float pegRatio;

  @JsonProperty("BookValue")
  private Float bookValue;

  @JsonProperty("DividendPerShare")
  private Float dividendPerShare;

  @JsonProperty("DividendYield")
  private Float dividendYield;

  @JsonProperty("EPS")
  private Float eps;

  @JsonProperty("RevenuePerShareTTM")
  private Float revenuePerShareTTM;

  @JsonProperty("ProfitMargin")
  private Float profitMargin;

  @JsonProperty("OperatingMarginTTM")
  private Float operatingMarginTTM;

  @JsonProperty("ReturnOnAssetsTTM")
  private Float returnOnAssetsTTM;

  @JsonProperty("ReturnOnEquityTTM")
  private Float returnOnEquityTTM;

  @JsonProperty("RevenueTTM")
  private Double revenueTTM;

  @JsonProperty("GrossProfitTTM")
  private Double grossProfitTTM;

  @JsonProperty("DilutedEPSTTM")
  private Float dilutedEPSTTM;

  @JsonProperty("QuarterlyEarningsGrowthYOY")
  private Float quarterlyEarningsGrowthYOY;

  @JsonProperty("QuarterlyRevenueGrowthYOY")
  private Float quarterlyRevenueGrowthYOY;

  @JsonProperty("AnalystTargetPrice")
  private Float analystTargetPrice;

  @JsonProperty("TrailingPE")
  private Float trailingPE;

  @JsonProperty("ForwardPE")
  private Float forwardPE;

  @JsonProperty("PriceToSalesRatioTTM")
  private Float priceToSalesRatioTTM;

  @JsonProperty("PriceToBookRatio")
  private Float priceToBookRatio;

  @JsonProperty("EVToRevenue")
  private Float evToRevenue;

  @JsonProperty("EVToEBITDA")
  private Float evToEBITDA;

  @JsonProperty("Beta")
  private Float beta;

  @JsonProperty("52WeekHigh")
  private Float _52WeekHigh;

  @JsonProperty("52WeekLow")
  private Float _52WeekLow;

  @JsonProperty("50DayMovingAverage")
  private Float _50DayMovingAverage;

  @JsonProperty("200DayMovingAverage")
  private Float _200DayMovingAverage;

  @JsonProperty("SharesOutstanding")
  private Double sharesOutstanding;

  @JsonProperty("DividendDate")
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime dividendDate;

  @JsonProperty("ExDividendDate")
  @JsonDeserialize(using = EasternZonedDateDeserializer.class)
  private ZonedDateTime exDividendDate;
}
