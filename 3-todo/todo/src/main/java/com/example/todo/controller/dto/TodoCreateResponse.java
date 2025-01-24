package com.example.todo.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TodoCreateResponse {
    private Long id;
    private String content;
    private String authorName;
}
