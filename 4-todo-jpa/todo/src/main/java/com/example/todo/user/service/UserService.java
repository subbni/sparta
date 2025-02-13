package com.example.todo.user.service;

import com.example.todo.exception.CustomException;
import com.example.todo.exception.ExceptionType;
import com.example.todo.config.security.PasswordEncoder;
import com.example.todo.user.domain.AccountStatus;
import com.example.todo.user.domain.User;
import com.example.todo.user.dto.CreateUserRequest;
import com.example.todo.user.dto.CreateUserResponse;
import com.example.todo.user.dto.UpdateUserRequest;
import com.example.todo.user.dto.UserProfile;
import com.example.todo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserResponse register(CreateUserRequest request) {
        checkDuplicateEmail(request.getEmail());
        User user = userRepository.save(
                User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        );
        return CreateUserResponse.from(user);
    }

    public UserProfile getUserProfile(Long userId) {
        return UserProfile.from(getUserById(userId));
    }

    public UserProfile update(Long userId, UpdateUserRequest request) {
        User user = getUserById(userId);
        user.update(request.getName(), passwordEncoder.encode(request.getPassword()));
        return UserProfile.from(user);
    }

    public void unregister(Long userId) {
        User user = getUserById(userId);

        user.setAccountStatus(AccountStatus.DELETED);
        userRepository.softDelete(userId);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new CustomException(ExceptionType.USER_NOT_FOUND);
                });
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> {
                    throw new CustomException(ExceptionType.EMAIL_NOT_EXIST);
                });
    }

    private void checkDuplicateEmail(String email) {
        if(userRepository.existsByEmail(email)) {
            throw new CustomException(ExceptionType.DUPLICATE_EMAIL);
        }
    }
}
