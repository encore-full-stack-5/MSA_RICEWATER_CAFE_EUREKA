package com.example.member.exception;

public class AlreadyDeletedException extends IllegalArgumentException{
    public AlreadyDeletedException(Long id) {
        super(id + " already deleted");
    }
}