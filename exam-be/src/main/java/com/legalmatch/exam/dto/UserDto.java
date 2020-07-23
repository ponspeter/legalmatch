package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonPropertyOrder({
        "userId",
        "personalInformation",
        "username",
        "password",
        "status",
        "role"
})
public class UserDto {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("personalInformation")
    private PersonalInformationDto personalInformation;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("status")
    private EmployeeStatusEnum status;

    @JsonProperty("role")
    private RoleEnum role;
}
