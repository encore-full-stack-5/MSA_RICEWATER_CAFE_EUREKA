package com.example.comment.controller;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.dto.request.ReplyRequest;
import com.example.comment.dto.response.CommentResponse;
import com.example.comment.dto.response.ReplyResponse;
import com.example.comment.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/replies")
public class ReplyController {

    private final ReplyService replyService;

    // 댓글의 답글을 조회한다
    @GetMapping("/commnet/{commentId}")
    List<ReplyResponse> getReplyByCommnetId(
            @PathVariable("commentId") Long commentId,
            @PageableDefault(
                    page = 0,
                    size = 3,
                    sort = "id",
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        return replyService.getReplyByCommentId(commentId, pageable);
    }

    // 댓글의 답글을 단일 조회한다
    @GetMapping("/{id}")
    ReplyResponse getReplyById(
            @PathVariable("id") Long id
    ) {
        return replyService.getReplyById(id);
    }

    // 댓글에 답글을 추가한다
    @PostMapping
    public void createReply(
            @RequestBody ReplyRequest replyRequest
    ) {
        replyService.createReply(replyRequest);
    }

    // 댓글의 답글을 수정한다
    @PutMapping("/{id}")
    public void updateReply(
            @PathVariable("id") Long id,
            @RequestBody ReplyRequest replyRequest
    ) {
        replyService.updateReply(id, replyRequest);
    }

    // 댓글의 답글을 삭제한다
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReply(
            @PathVariable("id") Long id
    ) {
        replyService.deleteReply(id);
    }
}