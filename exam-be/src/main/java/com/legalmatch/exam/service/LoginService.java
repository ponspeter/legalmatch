package com.legalmatch.exam.service;

import com.legalmatch.exam.dto.PersonalInformationDto;
import com.legalmatch.exam.dto.UserDto;
import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.enums.RoleEnum;
import com.legalmatch.exam.model.User;
import com.legalmatch.exam.repository.EmployeeRepository;
import com.legalmatch.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginService implements DefaultLoginService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto login(UserDto dto) {
        User findUserPassword = userRepository.findByUsernameAndStatus(dto.getUsername(), EmployeeStatusEnum.ACTIVE);

        System.out.println(passwordEncoder.matches(dto.getPassword(), findUserPassword.getPassword()));

        String encodedPassword = passwordEncoder.matches(dto.getPassword(), findUserPassword.getPassword())
                ? findUserPassword.getPassword() : "Password mismatch";

        User user = userRepository.findByUsernameAndPasswordAndStatus(
                dto.getUsername(), encodedPassword, EmployeeStatusEnum.ACTIVE);
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
