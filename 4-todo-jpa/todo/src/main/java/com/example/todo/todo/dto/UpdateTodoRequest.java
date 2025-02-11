package com.example.todo.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateTodoRequest {

    @NotBlank
    @Size(min = 1, max = 100, message = "length min 1, max 100")
    String title;

    @NotBlank
    @Size(min = 1, max = 200, message = "length min 1, max 200")
    String content;
}
