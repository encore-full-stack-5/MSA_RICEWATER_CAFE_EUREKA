package com.example.board.dto.request;

import com.example.board.global.domain.entity.Board;

import java.time.LocalDateTime;

public record InsertBoardRequestDto (
        String boardTitle, String boardContent, Long cafeId, Long subGroupId, Long memberId
) {
    public Board toEntity(){
        return Board.builder()
                .id(0L)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .cafeId(cafeId)
                .subGroupId(subGroupId)
                .memberId(memberId)
                .createdAt(LocalDateTime.now())
                .boardViews(0L)
                .build();
    }

}
