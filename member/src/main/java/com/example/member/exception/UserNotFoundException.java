package com.example.member.exception;

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException(Long userId) {
        super(userId + " not found");
    }
}
