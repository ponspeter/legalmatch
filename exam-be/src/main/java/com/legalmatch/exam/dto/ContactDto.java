package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ContactDto {

    @JsonProperty("contactId")
    private long contactId;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("email")
    private String email;

    @JsonProperty("isPrimary")
    private boolean isPrimary;

    public boolean hasCompleteDetails() {
        return StringUtils.isNotEmpty(mobile) &&
               StringUtils.isNotEmpty(email) &&
               StringUtils.isNotEmpty(phone);
    }
}
