package com.example.todo.comment.dto;

import com.example.todo.comment.domain.Comment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {

    private Long id;
    private String content;
    private Long userId;
    private String userName;
    private Long todoId;

    public static CommentResponse from(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .userId(comment.getUser().getId())
                .userName(comment.getUser().getName())
                .todoId(comment.getTodo().getId())
                .build();
    }
}
