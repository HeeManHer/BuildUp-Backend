package com.warmmingup.buildup.comment.service;

import com.warmmingup.buildup.comment.dao.CommentMapper;
import com.warmmingup.buildup.comment.dto.CommentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    private static CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDTO> findAllComments(int commentConnect) {

        return commentMapper.selectAllComments(commentConnect);
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
    @Transactional
    public void deleteComment(int replyNo) {

        commentMapper.deleteComment(replyNo);
    }


}
