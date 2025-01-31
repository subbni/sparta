package com.example.todo.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateRequest {
    @NotBlank
    String name;
    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9]+(?:[._%+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,6})+$",
    message = "invalid email format")
    // ref https://www.notion.so/18ca2f5349be80508ee0ce220859a87f?pvs=4
    String email;
    @NotBlank
    String password;

}
