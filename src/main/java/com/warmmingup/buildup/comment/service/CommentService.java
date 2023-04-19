package com.warmmingup.buildup.comment.service;

import com.warmmingup.buildup.comment.dto.CommentDTO;

import java.util.List;


public interface CommentService {

    List<CommentDTO> findAllComments(int commentConnect);

   int insertComment(CommentDTO newComment);

    void updateComment(CommentDTO newComment);

    Object patchComment(CommentDTO newComment);

    void deleteComment(int replyNo);
}
