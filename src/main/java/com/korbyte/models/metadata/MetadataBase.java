package com.korbyte.models.metadata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Alpha Vantage API BaseMetadata
 */
@Data
public abstract class MetadataBase {

    @JsonProperty(required = true, value = "1. Information")
    private String information;

    @JsonProperty(required = true, value = "2. Symbol")
    private String symbol;

    @JsonProperty(value = "3. Last Refreshed")
    private String lastRefreshed;
}
