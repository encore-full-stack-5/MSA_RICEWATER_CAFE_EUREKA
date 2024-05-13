package com.example.comment.service;

import com.example.comment.dto.request.ReplyRequest;
import com.example.comment.dto.response.CommentResponse;
import com.example.comment.dto.response.ReplyResponse;
import com.example.comment.exception.CommentIdNotFoundException;
import com.example.comment.exception.ReplyIdNotFoundException;
import com.example.comment.global.domain.entity.Comment;
import com.example.comment.global.domain.entity.Reply;
import com.example.comment.global.domain.repository.CommentRepository;
import com.example.comment.global.domain.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    // 댓글 내 답글 조회
    @Override
    public List<ReplyResponse> getReplyByCommentId(Long commentId, Pageable pageable) {
        List<Reply> all = replyRepository.findByCommentId(commentId, pageable);
        return all.stream().map(ReplyResponse::from).toList();
    }

    // 답글 단일 조회
    @Override
    public ReplyResponse getReplyById(Long id) {
        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> new ReplyIdNotFoundException(id));
        return ReplyResponse.from(reply);
    }

    // 답글 추가
    @Override
    @Transactional
    public void createReply(ReplyRequest replyRequest) {
        // 댓글Id가 없으면 에러처리
        replyRepository.save(replyRequest.toEntity());
    }

    @Override
    @Transactional
    public void updateReply(Long id, ReplyRequest request) {
        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> new ReplyIdNotFoundException(id));

        reply.setContent(request.content());
    }

    @Override
    @Transactional
    public void deleteReply(Long id) {
        Reply byId = replyRepository.findById(id)
                .orElseThrow(() -> new ReplyIdNotFoundException(id));
        replyRepository.delete(byId);
    }
}