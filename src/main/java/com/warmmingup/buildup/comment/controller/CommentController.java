package com.warmmingup.buildup.comment.controller;

import com.warmmingup.buildup.comment.dto.CommentDTO;
import com.warmmingup.buildup.comment.service.CommentService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/comments")
    public ResponseEntity<ResponseDTO> getComment(@RequestParam(name = "offset", defaultValue = "1") int offset) {

        int limit = 10;

        int startComment = offset + 1;
        int endComment = startComment + limit;

        Map<String, Integer> CommentConnect = new HashMap<>();
        CommentConnect.put("start", startComment);
        CommentConnect.put("end", endComment);

        List<CommentDTO> reply = commentService.findAllComments();
        System.out.println(reply);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공!", reply));
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> insertComment(@RequestBody CommentDTO newComment) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,
                "상품 입력 성공",
                commentService.insertComment(newComment)));
    }

    @PutMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> updateComment(@RequestBody CommentDTO newComment) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,
                "상품 입력 성공",
                commentService.updateComment(newComment)));
    }
    @PatchMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> patchComment(@RequestBody CommentDTO newComment) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,
                "상품 입력 성공",
                commentService.patchComment(newComment)));
    }

    @DeleteMapping(value = "/comments")
    public ResponseEntity<ResponseDTO> deleteComment(@RequestBody CommentDTO newComment) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,
                "상품 입력 성공",
                commentService.deleteComment(newComment)));
    }
}
