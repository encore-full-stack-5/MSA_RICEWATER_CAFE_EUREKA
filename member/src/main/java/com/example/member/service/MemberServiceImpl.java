package com.example.member.service;

import com.example.member.dto.request.MemberRequest;
import com.example.member.dto.response.MemberResponse;
import com.example.member.exception.AlreadyDeletedException;
import com.example.member.exception.ExistNicknameException;
import com.example.member.exception.ExistUserException;
import com.example.member.exception.MemberNotFoundException;
import com.example.member.global.domain.entity.Member;
import com.example.member.global.domain.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    // 카페 멤버 조회 (단일 조회)
    @Override
    public MemberResponse getMemberById(Long id) {
        Optional<Member> byId = memberRepository.findByMemberStatusFalseAndId(id);
        Member member = byId.orElseThrow(() -> new MemberNotFoundException(id));
        return MemberResponse.from(member);
    }

    // 카페별 가입된 멤버 조회
    @Override
    public List<MemberResponse> getCafeMembersByCafeId(Long cafeId, Pageable pageable) {
        List<Member> all = memberRepository.findByMemberStatusFalseAndCafeId(cafeId, pageable);
        return all.stream().map(MemberResponse::from).toList();
    }

    // 카페에 가입한 멤버 추가
    @Transactional
    @Override
    public void createMemberId(
            MemberRequest memberRequest
    ) {
        Optional<Member> byUserId = memberRepository.findByUserId(memberRequest.userId());
        if(byUserId.isPresent()) throw new ExistUserException(memberRequest.userId());
        Optional<Member> byNickname = memberRepository.findByNickname(memberRequest.nickname());
        if(byNickname.isPresent()) throw new ExistNicknameException(memberRequest.nickname());
        memberRepository.save(memberRequest.toEntity());
    }

    // 멤버 정보 수정
    @Transactional
    @Override
    public void updateMemberId(Long id, MemberRequest request) {
        Optional<Member> byId = memberRepository.findById(id);
        Member member = byId.orElseThrow(() -> new MemberNotFoundException(id));
        Optional<Member> byNickname = memberRepository.findByNickname(request.nickname());
        if(byNickname.isPresent()) throw new ExistNicknameException(request.nickname());

        member.setNickname(request.nickname());
        member.setProfileImage(request.profileImage());
        member.setAboutMe(request.aboutMe());
        member.setAgeVisibilityOption(request.ageVisibilityOption());
        member.setRankId(request.rankId());
    }

    // 멤버 카페 탈퇴
    @Transactional
    @Override
    public void deletedMemberId(Long id) {
        Optional<Member> byId = memberRepository.findByMemberStatusFalseAndId(id);
        Member member = byId.orElseThrow(() -> new AlreadyDeletedException(id));

        member.setMemberStatus(true);
    }
}