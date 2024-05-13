package com.example.category.dto.request;

import com.example.category.global.domain.entity.Category;

public record DeleteCategoryRequest(
        Boolean isDelete
) {
    public Category from(Category category) {
        category.setIsDelete(true);
        return category;
    }
}
