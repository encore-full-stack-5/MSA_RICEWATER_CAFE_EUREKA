package com.example.user.service;

import com.example.user.global.dto.UserDto;


public interface TokenService {

    UserDto getUserInfoFromToken(String userInfoFromToken);
}
