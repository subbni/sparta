package com.example.todo.entity;

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
    private String authorName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo(String content, String authorName, String password) {
        this.content = content;
        this.authorName = authorName;
        this.password = password;
    }
}
