package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressDto {

    @JsonProperty("addressId")
    private long addressId;

    @JsonProperty("houseNumber")
    private long houseNumber;

    @Size(max = 50)
    @JsonProperty("street")
    private String street;

    @Size(max = 50)
    @JsonProperty("town")
    private String town;

    @Size(max = 50)
    @JsonProperty("province")
    private String province;

    @JsonProperty("postalCode")
    private long postalCode;

    @JsonProperty("isPrimary")
    private boolean isPrimary;
}
