package com.legalmatch.exam.controller;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.UserDto;
import com.legalmatch.exam.enums.ResponseCode;
import com.legalmatch.exam.service.DefaultLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class LoginController {

    @GetMapping()
    public Principal user(Principal user) {
        System.out.println("PRINCIPAL " + user.getName());
        return user;
    }
}
