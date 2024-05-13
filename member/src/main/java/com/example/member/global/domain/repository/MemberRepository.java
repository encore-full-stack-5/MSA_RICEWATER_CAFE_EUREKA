package com.example.member.global.domain.repository;

import com.example.member.global.domain.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /*
     * SELECT M.*
     *   FROM CAFE_MEMBERS M
     *  WHERE M.MEMBER_STATUS = 0
     *    AND M.ID = ?
     */
    Optional<Member> findByMemberStatusFalseAndId(Long id);

    /*
     * SELECT M.*
     *   FROM CAFE_MEMBERS M
     *  WHERE MEMBER_STATUS = 0
     */
//    Boolean findByisMemberStatusFalse(Boolean memberStatus);

    /*
     * SELECT M.*
     *   FROM CAFE_MEMBERS M
     *  WHERE CAFE_ID = ?
     */
    List<Member> findByMemberStatusFalseAndCafeId(Long cafeId, Pageable pageable);

    Optional<Member> findByNickname(String nickname);

    Optional<Member> findByUserId(UUID userId);
}