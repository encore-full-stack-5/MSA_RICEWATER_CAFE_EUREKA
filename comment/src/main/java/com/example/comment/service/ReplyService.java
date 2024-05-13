package com.example.comment.service;

import com.example.comment.dto.request.CommentRequest;
import com.example.comment.dto.request.ReplyRequest;
import com.example.comment.dto.response.CommentResponse;
import com.example.comment.dto.response.ReplyResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReplyService {
    /*
     * @param commentId
     * @return List<ReplyResponse>
     * @method GET
     *
     * 댓글의 답글을 조회한다
     */
    List<ReplyResponse> getReplyByCommentId(Long commentId, Pageable pageable);

    /*
     * @param id
     * @return ReplyResponse
     * @method GET
     *
     * 댓글의 답글을 단일 조회한다
     */
    ReplyResponse getReplyById(Long id);

    /*
     * @param replyRequest
     * @return void
     * @method POST
     *
     * 댓글에 답글을 추가한다
     */
    void createReply(ReplyRequest replyRequest);

    /*
     * @param id, replyRequest
     * @return void
     * @method PUT
     *
     * 댓글의 답글을 수정한다
     */
    void updateReply(Long id, ReplyRequest replyRequest);

    /*
     * @param id
     * @return void
     * @method DELETE
     *
     * 댓글의 답글을 삭제한다
     */
    void deleteReply(Long id);
}
