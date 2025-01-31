package com.example.todo.todo.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class TodoCreateRequest {

    @NotNull
    @Size(min=1, max=200, message = "length min 1, max 20")
    private String content;
    private String userName;
    @NotBlank
    @Email(regexp = "^[a-zA-Z0-9]+(?:[._%+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,6})+$",
    message = "invalid email format")
    private String email;
    // docs : email 검증 형식 https://www.notion.so/18ca2f5349be80508ee0ce220859a87f?pvs=4
    @NotBlank
    private String password;
}
