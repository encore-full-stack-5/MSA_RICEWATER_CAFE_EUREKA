package com.example.comment.service;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.dto.response.CommentResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    /*
     * @param boardId
     * @return List<CommentResponse>
     * @method GET
     *
     * 게시글의 댓글을 조회한다
     */
    List<CommentResponse> getCommentByBoardId(Long boardId, Pageable pageable);

    /*
     * @param id
     * @return CommentResponse
     * @method GET
     *
     * 게시글의 댓글을 단일 조회한다
     */
    CommentResponse getCommentById(Long id);

    /*
     * @param commentRequest
     * @return void
     * @method POST
     *
     * 게시글에 댓글을 추가한다
     */
    void createComment(CommentRequest commentRequest);

    /*
     * @param id, commentRequest
     * @return void
     * @method PUT
     *
     * 게시글의 댓글을 수정한다
     */
    void updateComment(Long id, CommentRequest commentRequest);

    /*
     * @param id
     * @return void
     * @method DELETE
     *
     * 게시글의 댓글을 삭제한다
     */
    void deleteComment(Long id);
}