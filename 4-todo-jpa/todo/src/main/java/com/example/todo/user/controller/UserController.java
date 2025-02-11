package com.example.todo.user.controller;

import com.example.todo.exception.CustomException;
import com.example.todo.exception.ExceptionType;
import com.example.todo.global.annotation.CurrentUserId;
import com.example.todo.user.dto.CreateUserResponse;
import com.example.todo.user.dto.UpdateUserRequest;
import com.example.todo.user.dto.UserProfile;
import com.example.todo.user.dto.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> register(
            @Valid @RequestBody CreateUserRequest request
    ) {
        return new ResponseEntity<>(userService.register(request), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfile> getUserProfile(
            @PathVariable Long userId
    ) {
        return new ResponseEntity<>(userService.getUserProfile(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserProfile> update(
            @CurrentUserId Long currentUserId,
            @PathVariable Long userId,
            @Valid @RequestBody UpdateUserRequest request
    ) {
        if(!currentUserId.equals(userId)) {
            throw new CustomException(ExceptionType.NO_PERMISSION_ACTION);
        }

        return new ResponseEntity<>(userService.update(userId, request), HttpStatus.OK);
    }

}
