package com.example.todo.todo.dto;

import lombok.Getter;

@Getter
public class TodoCreateRequest {
    private String content;
    private String userName;
    private String email;
    private String password;
}
