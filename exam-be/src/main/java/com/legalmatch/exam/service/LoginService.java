package com.legalmatch.exam.service;

import com.legalmatch.exam.dto.PersonalInformationDto;
import com.legalmatch.exam.dto.UserDto;
import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.enums.RoleEnum;
import com.legalmatch.exam.model.User;
import com.legalmatch.exam.repository.EmployeeRepository;
import com.legalmatch.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements DefaultLoginService {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDto login(UserDto dto) {
        User user = userRepository.findByUsernameAndPasswordAndStatus(dto.getUsername(), dto.getPassword(), EmployeeStatusEnum.ACTIVE);
        return UserDto.builder()
                .username(user.getUsername())
                .status(user.getStatus())
                .role(user.getRole())
                .personalInformation(PersonalInformationDto.builder()
                        .personalInformationId(user.getInformation().getId())
                        .firstName(user.getInformation().getFirstName())
                        .middleName(user.getInformation().getMiddleName())
                        .lastName(user.getInformation().getLastName())
                        .build())
                .build();
    }
}
