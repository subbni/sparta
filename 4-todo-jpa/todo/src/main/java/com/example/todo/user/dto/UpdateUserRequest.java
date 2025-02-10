package com.example.todo.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    @NotBlank
    @Size(min = 1, max=100, message = "length min 1, max 100")
    private String name;
    @NotBlank
    String password;
}
