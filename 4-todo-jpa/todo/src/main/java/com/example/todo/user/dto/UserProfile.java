package com.example.todo.user.dto;

import com.example.todo.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserProfile {

    private Long id;
    private String name;
    private String email;

    public static UserProfile from(User user) {
        return UserProfile.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
