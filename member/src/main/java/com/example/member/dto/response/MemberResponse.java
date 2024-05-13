package com.example.member.dto.response;

import com.example.member.global.domain.entity.Member;

import java.time.LocalDateTime;
import java.util.UUID;

// 응답
public record MemberResponse(
        String id,
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
    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId().toString(),
                member.getProfileImage(),
                member.getNickname(),
                member.getAboutMe(),
                member.getAgeVisibilityOption(),
                member.getJoinAnswer(),
                member.getMemberStatus(),
                member.getUserId(),
                member.getCafeId(),
                member.getRankId(),
                member.getJoinDate()
        );
    }
}