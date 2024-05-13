package com.example.member.exception;

public class ExistNicknameException extends IllegalArgumentException{
    public ExistNicknameException(String nickname) {
        super(nickname + " already exists");
    }
}
