package com.example.todo.user.service;

import com.example.todo.user.domain.User;
import com.example.todo.user.dto.UserCreateRequest;
import com.example.todo.user.dto.UserResponse;
import com.example.todo.user.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse save(UserCreateRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
        Long generatedId = userRepository.saveAndReturnKey(user);

        return UserResponse.builder()
                .id(generatedId)
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
    public UserResponse findOrSave(UserCreateRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .map(UserResponse::fromEntity)
                .orElseGet(() -> save(request));
    }

    public void updateName(Long id, String name) {
        userRepository.updateName(id,name);
    }
}
