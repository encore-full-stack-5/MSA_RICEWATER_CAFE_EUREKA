package com.example.cafe.global.domain.dto;

import java.time.LocalDateTime;

public record CafeDto(
        Long id,
        String name,
        String icon,
        Boolean visibility,
        Boolean useNameOption,
        String description,
        Long managerId,
        Boolean joinQuestionYn,
        String joinQuestion,
        String address,
        String cafeRank,
        Boolean rankUseYn,
        LocalDateTime date

        ) {
}
