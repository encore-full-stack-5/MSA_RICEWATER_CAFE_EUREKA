package com.example.cafe.global.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RankType {
    SEED("씨앗"),// 씨앗
    SPROUT("새싹"),// 새싹
    LEAF("잎새"),// 잎새
    BRANCH("가지"),// 가지
    BERRY("열매"), // 열매
    TREE("나무"); // 나무
    private final String name;

}
