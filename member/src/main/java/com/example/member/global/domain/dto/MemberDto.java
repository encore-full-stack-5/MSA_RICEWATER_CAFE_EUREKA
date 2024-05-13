package com.example.member.global.domain.dto;

import java.time.LocalDateTime;

public record MemberDto(
        Long id,
        String profileImage,
        String nickname,
        String aboutMe,
        Boolean ageVisibilityOption,
        String joinAnswer,
        Boolean memberStatus,
        LocalDateTime joinDate,
        Long userId,
        Long cafeId,
        Long rankId
) {
}
