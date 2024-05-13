package com.example.board.dto.request;

import com.example.board.global.domain.entity.Board;

public record UpdateBoardRequestDto(
        String boardTitle, String boardContent
) {
}
