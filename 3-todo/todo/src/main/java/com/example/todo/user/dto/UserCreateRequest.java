package com.example.todo.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateRequest {
    String name;
    String email;
    String password;

}
