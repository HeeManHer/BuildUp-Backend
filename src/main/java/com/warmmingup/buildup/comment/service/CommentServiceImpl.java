package com.warmmingup.buildup.comment.service;

import com.warmmingup.buildup.comment.dao.CommentMapper;
import com.warmmingup.buildup.comment.dto.CommentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    private static CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {this.commentMapper = commentMapper;}

    /* 댓글 조회 */
    @Override
    public List<CommentDTO> findAllComments(int commentConnect) {
        List<CommentDTO> reply = commentMapper.findAllComments(commentConnect);
        System.out.println(reply);

        return reply;
    }

    /* 댓글 등록 */
    @Override
    @Transactional
    public int insertComment(CommentDTO newComment) {
        commentMapper.insertComment(newComment);

        return commentMapper.selectCommentNo();
    }

    /* 댓글 수정 */
    @Override
    @Transactional
    public void updateComment(CommentDTO newComment) {

        commentMapper.updateComment(newComment);

    }

    /* API 부분수정 예시 사용 안함*/
    /* @Override
    public Object patchComment(CommentDTO newComment) {

        int result = commentMapper.patchComment(newComment);

        return (result > 0) ? "수정 성공" : "수정 실패";
    }*/

    /* 댓글 삭제 */
    @Override
    @Transactional
    public void deleteComment(int replyNo) {
        commentMapper.deleteComment(replyNo);

    }


}
