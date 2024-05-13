package com.example.member.dto.request;

import com.example.member.global.domain.entity.Member;

import java.time.LocalDateTime;
import java.util.UUID;

public record MemberRequest(
        String profileImage,
        String nickname,
        String aboutMe,
        Boolean ageVisibilityOption,
        String joinAnswer,
        Boolean memberStatus,
        UUID userId,
        Long cafeId,
        Long rankId,
        LocalDateTime joinDate
) {
    public Member toEntity() {
        return Member.builder()
                .id(null)
                .profileImage(profileImage)
                .nickname(nickname)
                .aboutMe(aboutMe)
                .ageVisibilityOption(ageVisibilityOption)
                .joinAnswer(joinAnswer)
                .memberStatus(false)
                .userId(userId)
                .cafeId(cafeId)
                .rankId(rankId)
                .joinDate(LocalDateTime.now())
                .build();
    }
}