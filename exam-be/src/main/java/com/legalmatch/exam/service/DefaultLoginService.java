package com.legalmatch.exam.service;

import com.legalmatch.exam.dto.BaseReponse;
import com.legalmatch.exam.dto.UserDto;

public interface DefaultLoginService {

    UserDto login(UserDto userDto);
}
