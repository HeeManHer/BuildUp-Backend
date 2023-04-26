package com.warmmingup.buildup.comment.controller;

import com.warmmingup.buildup.comment.dto.CommentDTO;
import com.warmmingup.buildup.comment.service.CommentService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/issue/{issueNo}/comments")
    public ResponseEntity<ResponseDTO> getComment(@RequestParam(name = "offset", defaultValue = "1") int offset, @PathVariable int issueNo) {

        List<CommentDTO> reply = commentService.findAllComments(issueNo);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공!", reply));
    }


    @PostMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> insertComment(@RequestBody CommentDTO newComment) {

        newComment.setReplyDate(new Date());

        int replyNo = commentService.insertComment(newComment);

        return ResponseEntity.created(URI.create("/api/v1/comments/" + replyNo)).build();
    }

    @PutMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> updateComment(@RequestBody CommentDTO newComment) {

        newComment.setReplyDate(new Date());

        commentService.updateComment(newComment);

        return ResponseEntity.created(URI.create("/api/v1/comments/" + newComment.getReplyNo())).build();
    }

    @DeleteMapping(value = "/comments/{replyNo}")
    public ResponseEntity<ResponseDTO> deleteComment(@PathVariable int replyNo) {

        commentService.deleteComment(replyNo);
        return ResponseEntity.created(URI.create("/api/v1/comments/" + replyNo)).build();
    }

}
