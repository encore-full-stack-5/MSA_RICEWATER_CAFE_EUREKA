package com.example.user.domain.response;

public record UserResponse (
        String id,
        String email,
        String nickname,
        String birthDay,
        String gender
){
}
