package com.example.comment.dto.request;

import com.example.comment.global.domain.entity.Comment;

import java.time.LocalDateTime;

public record CommentRequest(
        String content,
        Long boardId,
        Long memberId
) {
    public Comment toEntity(Boolean visibility) {
        return Comment.builder()
                .id(null)
                .content(content)
                .createdAt(LocalDateTime.now())
                .boardId(boardId)
                .memberId(memberId)
                .visibility(visibility)
                .build();
    }
}
