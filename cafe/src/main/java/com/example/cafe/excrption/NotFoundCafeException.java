package com.example.cafe.excrption;

public class NotFoundCafeException extends IllegalArgumentException{
    public NotFoundCafeException() {
        super("Cafe Not Exists");
    }
}
