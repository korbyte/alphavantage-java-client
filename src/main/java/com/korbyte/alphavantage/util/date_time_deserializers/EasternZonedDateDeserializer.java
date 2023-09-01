package com.korbyte.alphavantage.util.date_time_deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;

public class EasternZonedDateDeserializer extends JsonDeserializer<ZonedDateTime> {

  @Override
  public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    String dateTimeStr = p.getText();
    return BaseZonedDateTimeBaseDeserializer.deserialize(dateTimeStr, "America/New_York");
  }
}
