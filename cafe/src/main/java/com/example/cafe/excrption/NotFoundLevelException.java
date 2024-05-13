package com.example.cafe.excrption;


public class NotFoundLevelException extends IllegalArgumentException{
    public NotFoundLevelException() {
        super("Level Not Exists");
    }
}
