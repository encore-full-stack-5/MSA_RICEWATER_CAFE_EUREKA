package com.example.cafe.dto.response;

import com.example.cafe.global.domain.entity.Cafe;

import java.time.LocalDateTime;

public record CafeResponse(
        String name,
        String icon,
        Boolean visibility,
        Boolean useNameOption,
        String description,
        Long managerId,
        Boolean joinQuestionYn,
        String joinQuestion,
        String address,
        String mainCategory,
        String subCategory,
        LocalDateTime createdAt

) {
    public static CafeResponse from(Cafe cafe) {
        return new CafeResponse(
                cafe.getName(),
                cafe.getIcon(),
                cafe.getVisibility(),
                cafe.getUseNameOption(),
                cafe.getDescription(),
                cafe.getManagerId(),
                cafe.getJoinQuestionYn(),
                cafe.getJoinQuestion(),
                cafe.getAddress(),
                cafe.getMainCategory(),
                cafe.getSubCategory(),
                cafe.getCreatedAt()
        );
    }
}
