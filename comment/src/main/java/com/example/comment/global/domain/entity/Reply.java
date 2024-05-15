package com.example.comment.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CAFE_REPLIES"
//        ,indexes = {@Index(columnList = "REPLY_ID")}
)
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_ID")
    private Long id;
    @Column(name = "CONTENT")
    @Setter
    private String content;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "COMMENT_ID")
    private Long commentId;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Column(name = "VISIBILITY")
    private Boolean visibility;
}