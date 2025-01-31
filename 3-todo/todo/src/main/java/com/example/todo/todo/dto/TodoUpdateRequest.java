package com.example.todo.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TodoUpdateRequest {
    @NotNull
    Long todoId;
    String userName;
    @NotNull
    @Size(min=1, max=200, message = "length min 1, max 200")
    String content;
    @NotBlank
    String password;
}
