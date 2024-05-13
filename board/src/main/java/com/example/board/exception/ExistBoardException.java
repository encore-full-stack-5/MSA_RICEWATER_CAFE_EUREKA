package com.example.board.exception;

public class ExistBoardException extends RuntimeException {
    public ExistBoardException() {
        super("Board already exists");
    }
}
