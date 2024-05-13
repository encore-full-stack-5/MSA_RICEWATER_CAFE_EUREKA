package com.example.category.exception;

public class AlreadyDeletedException extends IllegalArgumentException {
    public AlreadyDeletedException(Long id) {
        super(id + " already deleted");
    }
}