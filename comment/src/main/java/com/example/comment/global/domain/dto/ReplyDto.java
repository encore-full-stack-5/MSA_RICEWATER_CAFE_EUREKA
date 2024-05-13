package com.example.comment.global.domain.dto;

import java.time.LocalDateTime;

public record ReplyDto(
        Long id,
        String content,
        LocalDateTime createdAt,
        Long commentId,
        Long memberId
) {
}