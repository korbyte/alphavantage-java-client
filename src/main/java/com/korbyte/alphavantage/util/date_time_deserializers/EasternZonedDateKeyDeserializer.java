package com.korbyte.alphavantage.util.date_time_deserializers;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

import java.time.ZonedDateTime;

public class EasternZonedDateKeyDeserializer extends KeyDeserializer {

  @Override
  public ZonedDateTime deserializeKey(String key, DeserializationContext ctxt) {
    return BaseZonedDateTimeBaseDeserializer.deserialize(key, "America/New_York");
  }
}
