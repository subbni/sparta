package com.example.todo.controller.dto;

import lombok.Getter;

@Getter
public class TodoCreateRequest {
    private String content;
    private String authorName;
    private String password;
}
