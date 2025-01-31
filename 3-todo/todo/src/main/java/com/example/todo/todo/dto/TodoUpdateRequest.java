package com.example.todo.todo.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequest {
    Long todoId;
    String userName;
    String content;
    String password;
}
