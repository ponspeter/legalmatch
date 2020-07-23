package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.legalmatch.exam.enums.ResponseCode;
import com.legalmatch.exam.enums.Severity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonPropertyOrder({
        "code",
        "attribute",
        "message",
        "severity",
        "timestamp"
})
public class Error {

    @JsonProperty("code")
    private ResponseCode code;

    @JsonProperty("attribute")
    private String attribute;

    @JsonProperty("message")
    private String message;

    @JsonProperty("severity")
    private Severity severity;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;
}
