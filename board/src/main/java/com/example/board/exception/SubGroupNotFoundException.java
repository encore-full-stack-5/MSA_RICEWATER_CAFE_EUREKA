package com.example.board.exception;


public class SubGroupNotFoundException extends IllegalArgumentException{
    public SubGroupNotFoundException() {
        super("SubGroup does not exist");
    }
}
