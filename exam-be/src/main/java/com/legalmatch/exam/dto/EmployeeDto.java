package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.legalmatch.exam.enums.EmployeeStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonPropertyOrder({
        "employeeId",
        "personalInformation",
        "position",
        "status",
        "dateHired",
        "yearsInCompany"
})
public class EmployeeDto {

    @JsonProperty("employeeId")
    private Long employeeId;

    @JsonProperty("personalInformation")
    private PersonalInformationDto personalInformation;

    @JsonProperty("position")
    private String position;

    @JsonProperty("status")
    private EmployeeStatusEnum status;

    @JsonProperty("dateHired")
    private String dateHired;

    @JsonProperty("yearsInCompany")
    private String yearsInCompany;
}
