package com.example.todo.user.dto;

import com.example.todo.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserResponse {
    private Long id;
    private String name;
    private String email;

    public static CreateUserResponse from(User user) {
        return CreateUserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
