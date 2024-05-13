package com.example.comment.dto.response;

import com.example.comment.global.domain.entity.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        Long boardId,
        Long memberId
) {
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getBoardId(),
                comment.getMemberId()
        );
    }
}