package com.example.todo.todo.dto;

import com.example.todo.todo.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class TodoResponse {
    private Long id;
    private String content;
    private Long userId;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TodoResponse from(TodoDetail todoDetail) {
        return TodoResponse.builder()
                .id(todoDetail.getId())
                .content(todoDetail.getContent())
                .userId(todoDetail.getUserId())
                .userName(todoDetail.getUserName())
                .createdAt(todoDetail.getCreatedAt())
                .updatedAt(todoDetail.getUpdatedAt())
                .build();
    }
}
