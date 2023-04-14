package com.warmmingup.buildup.comment.service;

import com.warmmingup.buildup.comment.dao.CommentMapper;
import com.warmmingup.buildup.comment.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    private static CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {this.commentMapper = commentMapper;}

    @Override
    public List<CommentDTO> findAllComments() {

        return commentMapper.findAllComments();
    }

    @Override
    public Object insertComment(CommentDTO newComment) {

        int result = commentMapper.insertComment(newComment);

        return (result > 0) ? "등록 성공" : "등록 실패";
    }

    @Override
    public Object updateComment(CommentDTO newComment) {

        int result = commentMapper.updateComment(newComment);

        return (result > 0) ? "수정 성공" : "수정 실패";
    }

    @Override
    public Object patchComment(CommentDTO newComment) {

        int result = commentMapper.patchComment(newComment);

        return (result > 0) ? "수정 성공" : "수정 실패";
    }

    @Override
    public Object deleteComment(CommentDTO newComment) {

        int result = commentMapper.deleteComment(newComment);

        return (result > 0) ? "삭제 성공" : "삭제 실패";
    }

}
