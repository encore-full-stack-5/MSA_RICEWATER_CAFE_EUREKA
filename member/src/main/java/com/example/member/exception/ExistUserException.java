package com.example.member.exception;

import java.util.UUID;

public class ExistUserException extends IllegalArgumentException{
    public ExistUserException(UUID userId) {
        super(userId + " already exists");
    }
}