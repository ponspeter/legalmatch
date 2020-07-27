package com.legalmatch.exam.controller;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.UserDto;
import com.legalmatch.exam.enums.ResponseCode;
import com.legalmatch.exam.service.DefaultLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final DefaultLoginService loginService;

    @GetMapping()
    public BaseReponse<UserDto> authenticateUser(Principal user) {
        return BaseReponse.<UserDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(loginService.login(
                        UserDto.builder()
                                .username(user.getName())
                                .build()))
                .build();
    }
}
