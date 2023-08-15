package com.korbyte.models.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetadataDaily extends MetadataBase {
    @JsonProperty(value = "4. Output Size")
    private String outputSize;

    @JsonProperty(value = "5. Time Zone")
    private String timeZone;
}
