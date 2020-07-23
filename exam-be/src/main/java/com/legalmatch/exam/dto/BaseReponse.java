package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.legalmatch.exam.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonPropertyOrder({
        "code",
        "message",
        "data"
})
public class BaseReponse<T> {

    @JsonProperty("code")
    private ResponseCode code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;

    @JsonProperty("errors")
    private List<Error> errors;
}
