package com.example.comment.controller;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.dto.response.CommentResponse;
import com.example.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    // 게시글의 댓글을 조회한다
    @GetMapping("/board/{boardId}")
    List<CommentResponse> getCommentByBoardId(
            @PathVariable("boardId") Long boardId,
            @PageableDefault(
                    page = 0,
                    size = 3,
                    sort = "id",
                    direction = Sort.Direction.DESC
            )Pageable pageable
    ) {
        return commentService.getCommentByBoardId(boardId, pageable);
    }

    // 게시글의 댓글을 단일 조회한다
    @GetMapping("/{id}")
    CommentResponse getCommentById(
            @PathVariable("id") Long id
    ) {
        return commentService.getCommentById(id);
    }

    // 게시글에 댓글을 추가한다
    @PostMapping
    public void createComment(@RequestBody CommentRequest commentRequest) {
        commentService.createComment(commentRequest);
    }

    // 게시글의 댓글을 수정한다
    @PutMapping("/{id}")
    public void updateComment(
            @PathVariable("id") Long id,
            @RequestBody CommentRequest commentRequest
    ) {
        commentService.updateComment(id, commentRequest);
    }

    // 게시글의 댓글을 삭제한다
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(
            @PathVariable("id") Long id
    ) {
        commentService.deleteComment(id);
    }
}
