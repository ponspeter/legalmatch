package com.legalmatch.exam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.legalmatch.exam.enums.GenderEnum;
import com.legalmatch.exam.enums.MaritalStatusEnum;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonPropertyOrder({
        "personalInformationId",
        "firstName",
        "middleName",
        "lastName",
        "gender",
        "maritalStatus",
        "birthDate",
        "age",
        "contacts"
})
public class PersonalInformationDto {

    @JsonProperty("personalInformationId")
    private Long personalInformationId;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("gender")
    private GenderEnum gender;

    @JsonProperty("maritalStatus")
    private MaritalStatusEnum maritalStatus;

    @JsonProperty("birthDate")
    private String birthDate;

    @JsonProperty("age")
    private String age;

    @JsonProperty("contacts")
    @Singular("contact")
    private List<ContactDto> contacts;

    @JsonProperty("addresses")
    @Singular("address")
    private List<AddressDto> addresses;
}
