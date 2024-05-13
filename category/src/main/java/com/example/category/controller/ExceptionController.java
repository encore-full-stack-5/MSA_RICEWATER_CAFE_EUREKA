package com.example.category.controller;

import com.example.category.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AlreadyDeletedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerAlreadyDeletedException(AlreadyDeletedException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(CafeIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerCafeIdNotFoundException(CafeIdNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(CategoryIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerCategoryIdNotFoundException(CategoryIdNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(ExistNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerExistNameException(ExistNameException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(SubCategoryIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerSubCategoryIdNotFoundException(SubCategoryIdNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }
}