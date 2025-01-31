package com.example.todo.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Todo {
    private Long id;
    private String content;
    private Long userId;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo(String content, Long userId, String password) {
        this.content = content;
        this.userId = userId;
        this.password = password;
    }
}
