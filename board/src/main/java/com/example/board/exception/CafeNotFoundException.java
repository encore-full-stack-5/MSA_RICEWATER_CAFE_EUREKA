package com.example.board.exception;


public class CafeNotFoundException extends IllegalArgumentException{
    public CafeNotFoundException() {
        super("Cafe does not exist");
    }
}
