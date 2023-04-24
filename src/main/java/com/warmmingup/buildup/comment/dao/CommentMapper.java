package com.warmmingup.buildup.comment.dao;

import com.warmmingup.buildup.comment.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CommentMapper {

    /* 댓글 조회 */
    List<CommentDTO> findAllComments(int commentConnect);

    /* 댓글 등록 */
    int insertComment(CommentDTO newComment);

    /* 댓글 수정 */
    int updateComment(CommentDTO newComment);

    /* API 부분 수정 사용 안함 */
    /* int patchComment(CommentDTO newComment); */

    /* 댓글 삭제 */
    int deleteComment(int replyNo);

    int selectCommentNo();


}
