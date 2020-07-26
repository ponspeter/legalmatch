package com.legalmatch.exam.service;

import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.model.User;
import com.legalmatch.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements DefaultUserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndStatus(username, EmployeeStatusEnum.ACTIVE);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core
                .userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(Collections.singletonList(user.getRole().name())));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection <String> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.toString()))
                .collect(Collectors.toList());
    }
}
