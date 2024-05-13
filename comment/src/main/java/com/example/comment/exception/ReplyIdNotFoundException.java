package com.example.comment.exception;

public class ReplyIdNotFoundException extends IllegalArgumentException {
    public ReplyIdNotFoundException(Long id) {
        super(id + " not found");
    }
}