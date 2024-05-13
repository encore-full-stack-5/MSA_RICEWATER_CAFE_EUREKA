package com.example.category.dto.request;

import com.example.category.global.domain.entity.SubCategory;

public record DeleteSubCategoryRequest(
        Boolean isDelete
) {
    public SubCategory from(SubCategory subCategory) {
        subCategory.setIsDelete(true);
        return subCategory;
    }
}