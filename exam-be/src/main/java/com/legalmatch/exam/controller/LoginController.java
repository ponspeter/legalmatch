package com.legalmatch.exam.controller;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.UserDto;
import com.legalmatch.exam.enums.ResponseCode;
import com.legalmatch.exam.service.DefaultLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController implements DefaultLoginController {

    private final DefaultLoginService service;

    @Override
    @PostMapping()
    public BaseReponse<UserDto> login(@Valid @RequestBody UserDto userDto) {
        return BaseReponse.<UserDto>builder()
                .code(ResponseCode.SUCCESS)
                .data(service.login(userDto))
                .build();
    }
}
