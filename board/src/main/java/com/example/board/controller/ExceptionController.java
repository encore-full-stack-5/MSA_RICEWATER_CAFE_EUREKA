package com.example.board.controller;

import com.example.board.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController{
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userNotFoundExceptionHandler(UserNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(SubGroupNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String subGroupNotFoundExceptionHandler(SubGroupNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(ExistBoardException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String existBoardExceptionHandler(ExistBoardException e){
        return e.getMessage();
    }

    @ExceptionHandler(CafeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cafeNotFoundExceptionHandler(CafeNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(BoardTitleNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String boardTitleNotFoundExceptionHandler(BoardTitleNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(BoardNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String boardNotFoundExceptionHandler(BoardNotFoundException e){
        return e.getMessage();
    }


}
