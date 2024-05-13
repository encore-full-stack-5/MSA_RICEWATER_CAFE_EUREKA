package com.example.cafe.dto.request;

import com.example.cafe.global.domain.entity.Cafe;
import com.example.cafe.global.domain.entity.RankType;

import java.time.LocalDateTime;

public record CafeRequest(
        String name,
        String icon,
        Boolean visibility,
        Boolean useNameOption,
        String description,
        Long managerId,
        String createdAt,
        Boolean joinQuestionYn,
        String joinQuestion,
        String mainCategory,
        String subCategory,
        String address

){
    public Cafe toEntity(){
        return Cafe.builder()
                .id(null)
                .name(name)
                .icon(icon)
                .visibility(visibility)
                .useNameOption(useNameOption)
                .description(description)
                .managerId(managerId)
                .joinQuestionYn(joinQuestionYn)
                .joinQuestion(joinQuestion)
                .address(address)
                .cafeRank(RankType.SEED)
                .rankUseYn(false)
                .createdAt(LocalDateTime.now())
                .mainCategory(mainCategory)
                .subCategory(subCategory)
                .build();
    }
}
