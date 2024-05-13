package com.example.board.exception;

public class BoardTitleNotFoundException extends IllegalArgumentException{
    public BoardTitleNotFoundException() {
        super("BoardTitle does not exist");
    }
}
