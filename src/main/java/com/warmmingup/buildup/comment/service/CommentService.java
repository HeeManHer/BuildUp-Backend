package com.warmmingup.buildup.comment.service;

import com.warmmingup.buildup.comment.dto.CommentDTO;
import java.util.List;

public interface CommentService {

    /* 댓글 조회 */
    List<CommentDTO> findAllComments(int commentConnect);

    /* 댓글 등록 */
    int insertComment(CommentDTO newComment);

    /* 댓글 수정 */
    void updateComment(CommentDTO newComment);

    /* API 부분 수정 사용안함 */
    /* Object patchComment(CommentDTO newComment); */

    /* 댓글 삭제 */
    void deleteComment(int replyNo);
    
}

