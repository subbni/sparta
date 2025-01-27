package com.example.todo.todo.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequest {
    Long todoId;
    String authorName;
    String content;
    String password;
}
