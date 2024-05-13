package com.example.user.global.dto;

import java.util.Map;

public record UserDto(
        String id,
        String email,
        String nickname,
        String birthDay,
        String gender
){
    public static UserDto from(Map res){
        return new UserDto(
                res.get("id").toString(),
                res.get("email").toString(),
                res.get("nickname").toString(),
                res.get("birthDay").toString(),
                res.get("gender").toString()
        );
    }
}
