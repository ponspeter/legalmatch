package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressDto {

    @JsonProperty("addressId")
    private long addressId;

    @JsonProperty("houseNumber")
    private long houseNumber;

    @JsonProperty("street")
    private String street;

    @JsonProperty("town")
    private String town;

    @JsonProperty("province")
    private String province;

    @JsonProperty("postalCode")
    private long postalCode;

    @JsonProperty("isPrimary")
    private boolean isPrimary;
}
