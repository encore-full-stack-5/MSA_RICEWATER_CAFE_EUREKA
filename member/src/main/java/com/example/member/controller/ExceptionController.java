package com.example.member.controller;

import com.example.member.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerUserNotFoundException(UserNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerMemberNotFoundException(MemberNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(ExistNicknameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerExistNicknameException(ExistNicknameException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(ExistUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerExistUserException(ExistUserException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(AlreadyDeletedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerAlreadyWithdrawException(AlreadyDeletedException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }
}