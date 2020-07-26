package com.legalmatch.exam.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
        "errors"
})
public class ErrorsDto {
    private List<Error> errors;
}
