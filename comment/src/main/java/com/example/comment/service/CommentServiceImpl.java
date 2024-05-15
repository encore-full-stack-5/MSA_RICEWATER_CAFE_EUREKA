package com.example.comment.service;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.dto.response.ChatGptResponse;
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
    private final ChatGptService chatGptService;

    // 게시글 내 댓글 조회
    @Override
    public List<CommentResponse> getCommentByBoardId(Long boardId, Pageable pageable) {
        List<Comment> all = commentRepository.findByBoardIdAndVisibility(boardId,true, pageable);
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
        // gpt로 비속어가 포함되어 있는지 확인
        ChatGptResponse response = chatGptService.getResponse(commentRequest.content());
        if(response.getContent().toLowerCase().contains("false")) commentRepository.save(commentRequest.toEntity(false));
        else commentRepository.save(commentRequest.toEntity(true));
        // boardId가 없으면 에러처리
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