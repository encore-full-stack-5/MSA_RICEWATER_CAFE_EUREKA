package com.example.comment.global.domain.repository;

import com.example.comment.global.domain.entity.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 게시물 내 댓글 조회
    List<Comment> findByBoardIdAndVisibility(Long boardId, Boolean visibility, Pageable pageable);
}