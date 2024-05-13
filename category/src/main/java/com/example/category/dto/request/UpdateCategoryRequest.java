package com.example.category.dto.request;

import com.example.category.global.domain.entity.Category;

public record UpdateCategoryRequest(
        String name
) {
    public Category from(Category category) {
        category.setName(name);
        return category;
    }
}