package com.example.todo.comment.controller;

import com.example.todo.comment.dto.CommentResponse;
import com.example.todo.comment.dto.CreateCommentRequest;
import com.example.todo.comment.dto.UpdateCommentRequest;
import com.example.todo.comment.service.CommentFacadeService;
import com.example.todo.global.annotation.CurrentUserId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentFacadeService commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> create(
            @CurrentUserId Long userId,
            @Valid @RequestBody CreateCommentRequest request
    ) {
        return new ResponseEntity<>(commentService.create(userId,request), HttpStatus.CREATED);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponse> getComment(
            @PathVariable Long commentId
    ) {
        return new ResponseEntity<>(commentService.getComment(commentId),HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponse> update(
            @CurrentUserId Long userId,
            @PathVariable Long commentId,
            @Valid @RequestBody UpdateCommentRequest request
    ) {
        return new ResponseEntity<>(
                commentService.update(userId,commentId,request),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> delete(
            @CurrentUserId Long userId,
            @PathVariable Long commentId
    ) {
        commentService.delete(userId, commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
