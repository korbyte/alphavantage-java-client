package com.korbyte.models.core.daily;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.korbyte.models.metadata.MetadataDaily;
import lombok.Data;

import java.util.Map;

@Data
public class DailyResponse {
    @JsonProperty("Meta Data")
    private MetadataDaily metaData;

    @JsonProperty("Time Series (Daily)")
    private Map<String, DailyData> timeSeriesDailyAdjusted;
}
