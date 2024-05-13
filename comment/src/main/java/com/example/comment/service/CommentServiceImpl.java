package com.example.comment.service;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.dto.response.CommentResponse;
import com.example.comment.exception.CommentIdNotFoundException;
import com.example.comment.global.domain.entity.Comment;
import com.example.comment.global.domain.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    // 게시글 내 댓글 조회
    @Override
    public List<CommentResponse> getCommentByBoardId(Long boardId, Pageable pageable) {
        List<Comment> all = commentRepository.findByBoardId(boardId, pageable);
        return all.stream().map(CommentResponse::from).toList();
    }

    // 댓글 단일 조회
    @Override
    public CommentResponse getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentIdNotFoundException(id));
        return CommentResponse.from(comment);
    }

    // 댓글 추가
    @Override
    @Transactional
    public void createComment(CommentRequest commentRequest) {
        // boardId가 없으면 에러처리
        commentRepository.save(commentRequest.toEntity());
    }

    // 댓글 수정
    @Override
    @Transactional
    public void updateComment(Long id, CommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentIdNotFoundException(id));

        comment.setContent(request.content());
    }

    // 댓글 삭제
    @Override
    @Transactional
    public void deleteComment(Long id) {
        Comment byId = commentRepository.findById(id)
                .orElseThrow(() -> new CommentIdNotFoundException(id));
        commentRepository.delete(byId);
    }
}