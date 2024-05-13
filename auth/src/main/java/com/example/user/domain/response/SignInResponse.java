package com.example.user.domain.response;

public record SignInResponse (
        String token,
        String tokenType
){
    public static SignInResponse from(String token){
        return new SignInResponse(token, "Bearer ");
    }
}
