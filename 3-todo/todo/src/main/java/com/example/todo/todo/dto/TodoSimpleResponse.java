package com.example.todo.todo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TodoSimpleResponse {
    private Long id;
    private String content;
    private String userName;
}
