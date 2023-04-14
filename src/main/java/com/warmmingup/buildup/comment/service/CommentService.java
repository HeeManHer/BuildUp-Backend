package com.warmmingup.buildup.comment.service;

import com.warmmingup.buildup.comment.dto.CommentDTO;

import java.util.List;


public interface CommentService {

    List<CommentDTO> findAllComments();

   Object insertComment(CommentDTO newComment);

    Object updateComment(CommentDTO newComment);

    Object patchComment(CommentDTO newComment);

    Object deleteComment(CommentDTO newComment);
}
