package com.example.todo.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class TodoDeleteRequest {
    @NotNull
    Long id;
    @NotBlank
    String password;
}
