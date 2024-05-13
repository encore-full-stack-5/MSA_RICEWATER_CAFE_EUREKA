package com.example.user.service;


import com.example.user.domain.response.SignInResponse;
import com.example.user.global.dto.UserDto;


public interface AuthService {
    SignInResponse insertUser(UserDto req);
}
