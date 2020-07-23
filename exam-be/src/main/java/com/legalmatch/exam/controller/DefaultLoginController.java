package com.legalmatch.exam.controller;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.EmployeeDto;
import com.legalmatch.exam.dto.UserDto;

import java.util.List;

public interface DefaultLoginController {

    BaseReponse<UserDto> login(UserDto userDto);
}
