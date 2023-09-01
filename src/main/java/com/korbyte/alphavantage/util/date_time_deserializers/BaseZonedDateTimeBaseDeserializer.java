package com.korbyte.alphavantage.util.date_time_deserializers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BaseZonedDateTimeBaseDeserializer {

  public static ZonedDateTime deserialize(String input, String zoneId) {
    return deserialize(input, ZoneId.of(zoneId));
  }

  public static ZonedDateTime deserialize(String dateTimeStr, ZoneId zoneId) {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    if (dateTimeStr.contains(":")) {
      dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, dateFormatter);
      return localDateTime.atZone(zoneId);
    } else {
      LocalDate localDate = LocalDate.parse(dateTimeStr, dateFormatter);
      return localDate.atStartOfDay(zoneId);
    }
  }
}
