package com.example.todo.todo.dto;

import com.example.todo.todo.domain.Todo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TodoResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
    private String userName;

    public static TodoResponse from(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .userId(todo.getUser().getId())
                .userName(todo.getUser().getName())
                .build();
    }
}
