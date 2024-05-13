package com.example.board.exception;

public class BoardNotFoundException extends IllegalArgumentException{
    public BoardNotFoundException() {
        super("Board does not exist");
    }
}
