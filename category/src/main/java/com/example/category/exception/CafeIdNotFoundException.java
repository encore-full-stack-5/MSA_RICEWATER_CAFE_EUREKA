package com.example.category.exception;

public class CafeIdNotFoundException extends IllegalArgumentException {
    public CafeIdNotFoundException(Long cafeId) {
        super(cafeId + " not found");
    }
}
