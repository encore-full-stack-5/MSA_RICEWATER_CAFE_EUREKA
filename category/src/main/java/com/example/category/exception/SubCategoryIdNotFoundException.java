package com.example.category.exception;

public class SubCategoryIdNotFoundException extends IllegalArgumentException {
    public SubCategoryIdNotFoundException(Long id) {
        super(id + " not found");
    }
}