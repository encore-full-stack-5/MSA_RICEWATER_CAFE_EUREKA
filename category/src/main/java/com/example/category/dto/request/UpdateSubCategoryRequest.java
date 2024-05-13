package com.example.category.dto.request;

import com.example.category.global.domain.entity.Category;
import com.example.category.global.domain.entity.SubCategory;

public record UpdateSubCategoryRequest(
        String name
) {
    public SubCategory from(SubCategory subCategory) {
        subCategory.setName(name);
        return subCategory;
    }
}