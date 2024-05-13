package com.example.category.exception;

public class ExistNameException extends IllegalArgumentException {
    public ExistNameException(String name) {
        super(name + " already exists");
    }
}
