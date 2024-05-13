package com.example.comment.controller;

import com.example.comment.exception.BoardIdNotFoundException;
import com.example.comment.exception.CommentIdNotFoundException;
import com.example.comment.exception.ReplyIdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(BoardIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerBoardIdNotFoundException(BoardIdNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(CommentIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerCommentIdNotFoundException(CommentIdNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(ReplyIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerReplyIdNotFoundException(ReplyIdNotFoundException e) {
        log.debug(e.getMessage());
        return e.getMessage();
    }
}