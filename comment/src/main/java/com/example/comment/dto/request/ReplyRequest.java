package com.example.comment.dto.request;

import com.example.comment.global.domain.entity.Reply;

import java.time.LocalDateTime;

public record ReplyRequest(
        String content,
        Long commentId,
        Long memberId
) {
    public Reply toEntity() {
        return Reply.builder()
                .id(null)
                .content(content)
                .createdAt(LocalDateTime.now())
                .commentId(commentId)
                .memberId(memberId)
                .build();
    }
}
