package com.example.member.exception;

import java.util.UUID;

public class MemberNotFoundException extends IllegalArgumentException{
    public MemberNotFoundException(Long id) {
        super(id + " not found");
    }
}
