package com.warmmingup.buildup.comment.controller;

import com.warmmingup.buildup.comment.dto.CommentDTO;
import com.warmmingup.buildup.comment.service.CommentService;
import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.common.paging.Pagenation;
import com.warmmingup.buildup.common.paging.ResponseDtoWithPaging;
import com.warmmingup.buildup.common.paging.SelectCriteria;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(reply);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공!", reply));
    }


    @PostMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> insertComment(@RequestBody CommentDTO newComment) {

        newComment.setReplyDate(new Date());
        System.out.println(newComment);
        int replyNo= commentService.insertComment(newComment);

        return ResponseEntity.created(URI.create("/api/v1/comments/"+replyNo)).build();
    }

    @PutMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> updateComment(@RequestBody CommentDTO newComment) {

        newComment.setReplyDate(new Date());
        System.out.println(newComment);
        commentService.updateComment(newComment);

        return ResponseEntity.created(URI.create("/api/v1/comments/"+newComment.getReplyNo())).build();
    }
    @PatchMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> patchComment(@RequestBody CommentDTO newComment) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,
                "상품 입력 성공",
                commentService.patchComment(newComment)));
    }

    @DeleteMapping(value = "/comments/{replyNo}")
    public ResponseEntity<ResponseDTO> deleteComment(@PathVariable int replyNo) {

        commentService.deleteComment(replyNo);
        return ResponseEntity.created(URI.create("/api/v1/comments/"+replyNo)).build();
    }

}
