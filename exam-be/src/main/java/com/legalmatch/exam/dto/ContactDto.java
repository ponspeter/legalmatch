package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ContactDto {

    @JsonProperty("contactId")
    private long contactId;

    @Size(max = 30)
    @JsonProperty("phone")
    private String phone;

    @Size(max = 30)
    @JsonProperty("mobile")
    private String mobile;

    @Size(max = 100)
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
