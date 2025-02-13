package com.example.todo.user.service;

import com.example.todo.comment.service.CommentService;
import com.example.todo.todo.service.TodoService;
import com.example.todo.user.dto.CreateUserRequest;
import com.example.todo.user.dto.CreateUserResponse;
import com.example.todo.user.dto.UpdateUserRequest;
import com.example.todo.user.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserFacadeService {

    private final UserService userService;
    private final TodoService todoService;
    private final CommentService commentService;

    @Transactional
    public CreateUserResponse register(CreateUserRequest request) {
        return userService.register(request);
    }

    @Transactional(readOnly = true)
    public UserProfile getUserProfile(Long userId) {
        return userService.getUserProfile(userId);
    }

    @Transactional
    public UserProfile update(Long userId, UpdateUserRequest request) {
        return userService.update(userId, request);
    }

    @Transactional
    public void unregister(Long userId) {
        userService.unregister(userId);
        todoService.softDeleteByUserId(userId);
        commentService.softDeleteByUserId(userId);
    }
}
