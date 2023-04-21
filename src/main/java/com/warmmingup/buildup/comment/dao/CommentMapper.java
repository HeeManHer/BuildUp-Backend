package com.warmmingup.buildup.comment.dao;

import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import com.warmmingup.buildup.comment.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {

    List<CommentDTO> findAllComments(int commentConnect);


    int insertComment(CommentDTO newComment);

    int updateComment(CommentDTO newComment);


    int patchComment(CommentDTO newComment);

    int deleteComment(int replyNo);


    int selectCommentNo();


}
