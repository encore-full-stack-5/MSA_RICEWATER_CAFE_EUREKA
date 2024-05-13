package com.example.category.exception;

public class CategoryIdNotFoundException extends IllegalArgumentException {
    public CategoryIdNotFoundException(Long id) {
        super(id + " not found");
    }
}