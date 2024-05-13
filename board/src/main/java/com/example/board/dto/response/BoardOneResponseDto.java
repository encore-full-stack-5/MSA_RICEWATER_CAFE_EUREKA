package com.example.board.dto.response;

import com.example.board.global.domain.entity.Board;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BoardOneResponseDto(
        Long id,
        String boardTitle,
        String boardContent,
        Long boardViews,
        LocalDateTime createdAt,
        Long cafeId,
        Long subGroupId,
        Long memberId
) {
    public static BoardOneResponseDto from(Board board) {
        return new BoardOneResponseDto(
                board.getId()
                ,board.getBoardTitle()
                ,board.getBoardContent()
                ,board.getBoardViews()
                ,board.getCreatedAt()
                ,board.getCafeId()
                ,board.getSubGroupId()
                ,board.getMemberId());
    }
}
