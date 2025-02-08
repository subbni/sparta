package com.example.todo.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginUserRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
