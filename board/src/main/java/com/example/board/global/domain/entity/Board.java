package com.example.board.global.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="BOARDS")
@Builder
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;
    @Column(name = "BOARD_TITLE") @Setter
    private String boardTitle;
    @Column(name = "BOARD_CONTENT") @Setter
    private String boardContent; @Setter
    @Column(name = "BOARD_VIEWS")
    private Long boardViews;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "CAFE_ID")
    private Long cafeId;
    @Column(name = "SUB_GROUP_ID")
    private Long subGroupId;
    @Column(name = "MEMBER_ID")
    private Long memberId;
}
