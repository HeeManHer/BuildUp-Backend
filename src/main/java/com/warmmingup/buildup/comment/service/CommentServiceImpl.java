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

    @Override
    public List<CommentDTO> findAllComments(int commentConnect) {
        List<CommentDTO> reply = commentMapper.findAllComments(commentConnect);
        System.out.println(reply);

        return reply;
    }

    @Override
    @Transactional
    public int insertComment(CommentDTO newComment) {
        commentMapper.insertComment(newComment);

        return commentMapper.selectCommentNo();
    }

    @Override
    @Transactional
    public void updateComment(CommentDTO newComment) {

        commentMapper.updateComment(newComment);


    }

    @Override
    public Object patchComment(CommentDTO newComment) {

        int result = commentMapper.patchComment(newComment);

        return (result > 0) ? "수정 성공" : "수정 실패";
    }

    @Override
    @Transactional
    public void deleteComment(int replyNo) {
        commentMapper.deleteComment(replyNo);

    }

}
