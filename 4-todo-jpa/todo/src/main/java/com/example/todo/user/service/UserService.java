package com.example.todo.user.service;

import com.example.todo.global.exception.CustomException;
import com.example.todo.global.exception.ExceptionType;
import com.example.todo.security.PasswordEncoder;
import com.example.todo.user.domain.User;
import com.example.todo.user.dto.CreateUserRequest;
import com.example.todo.user.dto.CreateUserResponse;
import com.example.todo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CreateUserResponse create(CreateUserRequest request) {
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

    private void checkDuplicateEmail(String email) {
        if(userRepository.existsByEmail(email)) {
            throw new CustomException(ExceptionType.DUPLICATE_EMAIL);
        }
    }

    private void checkPasswordMatch(String inputPassword, String storedPassword) {
        if(!passwordEncoder.matches(inputPassword, storedPassword)) {
            throw new CustomException(ExceptionType.PASSWORD_NOT_MATCH);
        }
    }
}
