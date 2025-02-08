package com.example.todo.user.controller;

import com.example.todo.user.dto.CreateUserResponse;
import com.example.todo.user.service.UserService;
import com.example.todo.user.dto.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> create(
            @Valid @RequestBody CreateUserRequest request
    ) {
        return new ResponseEntity<>(userService.register(request), HttpStatus.CREATED);
    }
}
