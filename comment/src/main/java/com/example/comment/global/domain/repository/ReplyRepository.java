package com.example.comment.global.domain.repository;

import com.example.comment.global.domain.entity.Comment;
import com.example.comment.global.domain.entity.Reply;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // 댓글 내 답글 조회
    List<Reply> findByCommentId(Long commentId, Pageable pageable);
}