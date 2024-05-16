package com.example.comment.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CAFE_COMMENTS"
//        ,indexes = {@Index(columnList = "COMMENT_ID")}
)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;
    @Column(name = "CONTENT")
    @Setter
    private String content;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "BOARD_ID")
    private Long boardId;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Column(name = "VISIBILITY")
    private Boolean visibility;
}