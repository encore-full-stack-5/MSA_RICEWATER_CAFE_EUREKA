package com.example.cafe.controller;

import com.example.cafe.excrption.NotFoundCafeException;
import com.example.cafe.excrption.NotFoundLevelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundLevelException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundLevelException(NotFoundLevelException e){
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(NotFoundCafeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundCafeException(NotFoundCafeException e){
        log.debug(e.getMessage());
        return e.getMessage();
    }
}
