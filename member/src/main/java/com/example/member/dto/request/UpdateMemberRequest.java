package com.example.member.dto.request;

import com.example.member.global.domain.entity.Member;

public record UpdateMemberRequest(
        String profileImage,
        String nickname,
        String aboutMe,
        Boolean ageVisibilityOption,
        Long rankId
) {
    public Member from(Member member) {
        member.setProfileImage(profileImage);
        member.setNickname(nickname);
        member.setAboutMe(aboutMe);
        member.setAgeVisibilityOption(ageVisibilityOption);
        member.setRankId(rankId);
        return member;
    }
}
