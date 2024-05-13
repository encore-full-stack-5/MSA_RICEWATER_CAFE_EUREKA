package com.example.comment.global.domain.repository;

import com.example.comment.global.domain.entity.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 게시물 내 댓글 조회
    List<Comment> findByBoardId(Long boardId, Pageable pageable);
}