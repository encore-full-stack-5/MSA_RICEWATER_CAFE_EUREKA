package com.example.comment.global.domain.dto;

import java.time.LocalDateTime;

public record CommentDto(
        Long id,
        String content,
        LocalDateTime createdAt,
        Long boardId,
        Long memberId
) {
}