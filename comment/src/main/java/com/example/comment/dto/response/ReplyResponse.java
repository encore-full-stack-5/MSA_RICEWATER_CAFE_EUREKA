package com.example.comment.dto.response;

import com.example.comment.global.domain.entity.Reply;

import java.time.LocalDateTime;

public record ReplyResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        Long commentId,
        Long memberId
) {
    public static ReplyResponse from(Reply reply) {
        return new ReplyResponse(
                reply.getId(),
                reply.getContent(),
                reply.getCreatedAt(),
                reply.getCommentId(),
                reply.getMemberId()
        );
    }
}
