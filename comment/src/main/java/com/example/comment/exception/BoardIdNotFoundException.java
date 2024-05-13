package com.example.comment.exception;

public class BoardIdNotFoundException extends IllegalArgumentException {
    public BoardIdNotFoundException(Long boardId) {
        super(boardId + " not found");
    }
}
