package com.example.category.global.domain.dto;

public record CategoryDto(
        Long id,
        String name,
        Boolean isDelete,
        Long cafeId
) {
}