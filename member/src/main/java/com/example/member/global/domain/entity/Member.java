package com.example.member.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CAFE_MEMBERS"
//        ,indexes = {@Index(columnList = "MEMBER_ID")}
)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "PROFILE_IMAGE")
    @Setter
    private String profileImage;
    @Column(name = "NICKNAME")
    @Setter
    private String nickname;
    @Column(name = "ABOUT_ME")
    @Setter
    private String aboutMe;
    @Column(name = "AGE_VISIBILITY_OPTION")
    @Setter
    private Boolean ageVisibilityOption;
    @Column(name = "JOIN_ANSWER")
    private String joinAnswer;
    @Column(name = "MEMBER_STATUS")
    @Setter
    private Boolean memberStatus;
    @Column(name = "JOIN_DATE")
    private LocalDateTime joinDate;
    @Column(name = "USER_ID")
    private UUID userId;
    @Column(name = "CAFE_ID")
    private Long cafeId;
    @Column(name = "RANK_ID")
    @Setter
    private Long rankId;
}