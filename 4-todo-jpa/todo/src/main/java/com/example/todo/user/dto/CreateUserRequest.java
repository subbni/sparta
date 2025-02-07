package com.example.todo.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class CreateUserRequest {
    @NotBlank
    @Size(min = 1, max=100, message = "length min 1, max 100")
    private String name;

    @NotEmpty
    @Email(
            regexp = "^[a-zA-Z0-9]+(?:[._%+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,6})+$",
            message = "invalid email format"
    )
    String email;

    @NotBlank
    String password;
}
