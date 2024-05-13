package com.example.category.dto.request;

import com.example.category.global.domain.entity.Category;

public record CategoryRequest(
        String name,
        Boolean isDelete,
        Long cafeId
) {
    public Category toEntity() {
        return Category.builder()
                .id(null)
                .name(name)
                .isDelete(false)
                .cafeId(cafeId)
                .build();
    }
}