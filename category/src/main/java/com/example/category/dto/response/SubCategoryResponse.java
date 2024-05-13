package com.example.category.dto.response;

import com.example.category.global.domain.entity.Category;
import com.example.category.global.domain.entity.SubCategory;

public record SubCategoryResponse(
        Long id,
        String name,
        Boolean isDelete,
        Long categoryId
) {
    public static SubCategoryResponse from(SubCategory subCategory) {
        return new SubCategoryResponse(
                subCategory.getId(),
                subCategory.getName(),
                subCategory.getIsDelete(),
                subCategory.getCategoryId()
        );
    }
}