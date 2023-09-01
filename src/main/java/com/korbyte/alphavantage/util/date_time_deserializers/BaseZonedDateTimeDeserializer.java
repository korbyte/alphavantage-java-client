package com.korbyte.alphavantage.util.date_time_deserializers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BaseZonedDateTimeDeserializer {
  private static final String DEFAULT_ZONE_ID = "America/New_York";
  private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public static ZonedDateTime deserialize(String input) {
    return deserialize(input, ZoneId.of(DEFAULT_ZONE_ID), null);
  }

  public static ZonedDateTime deserialize(String input, String zoneId) {
    return deserialize(input, ZoneId.of(zoneId), null);
  }

  public static ZonedDateTime deserialize(String input, ZoneId zoneId) {
    return deserialize(input, zoneId, null);
  }

  public static ZonedDateTime deserialize(String input, String zoneId, String pattern) {
    DateTimeFormatter formatter = pattern != null ? DateTimeFormatter.ofPattern(pattern) : null;
    return deserialize(input, ZoneId.of(zoneId), formatter);
  }

  public static ZonedDateTime deserialize(String input, ZoneId zoneId, DateTimeFormatter formatter) {
    if (input == null || input.equals("null")) {
      return null;
    }

    if (zoneId == null) {
      zoneId = ZoneId.of(DEFAULT_ZONE_ID);
    }

    if (formatter == null) {
      formatter = input.contains(":") ? DATE_TIME_FORMATTER : DEFAULT_DATE_FORMATTER;
    }

    if (input.contains(":")) {
      LocalDateTime localDateTime = LocalDateTime.parse(input, formatter);
      return localDateTime.atZone(zoneId);
    } else {
      LocalDate localDate = LocalDate.parse(input, formatter);
      return localDate.atStartOfDay(zoneId);
    }
  }
}

