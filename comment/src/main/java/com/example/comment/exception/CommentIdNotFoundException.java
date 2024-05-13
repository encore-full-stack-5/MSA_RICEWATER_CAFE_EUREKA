package com.example.comment.exception;

public class CommentIdNotFoundException extends IllegalArgumentException {
    public CommentIdNotFoundException(Long id) {
        super(id + " not found");
    }
}