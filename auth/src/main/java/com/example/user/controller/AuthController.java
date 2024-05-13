package com.example.user.controller;

import com.example.user.domain.entity.User;
import com.example.user.domain.response.SignInResponse;
import com.example.user.global.dto.UserDto;
import com.example.user.service.AuthService;
import com.example.user.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final TokenService tokenService;

    @PostMapping("login")
    public SignInResponse login(@RequestHeader("Authorization") String token){
        UserDto userInfoFromToken = tokenService.getUserInfoFromToken(token);
        return authService.insertUser(userInfoFromToken);
    }

    @GetMapping("/refresh")
    public String getMe(@AuthenticationPrincipal User user){
        return "test";
    }
}
