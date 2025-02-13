package com.example.todo.todo.service;

import com.example.todo.comment.service.CommentService;
import com.example.todo.todo.dto.CreateTodoRequest;
import com.example.todo.todo.dto.TodoResponse;
import com.example.todo.todo.dto.TodoWithCommentCountResponse;
import com.example.todo.todo.dto.UpdateTodoRequest;
import com.example.todo.user.domain.User;
import com.example.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoFacadeService {

    private final TodoService todoService;
    private final UserService userService;
    private final CommentService commentService;

    @Transactional
    public TodoResponse create(Long userId, CreateTodoRequest request) {
        User user = userService.getUserById(userId);
        return todoService.create(user, request);
    }

    @Transactional(readOnly = true)
    public TodoResponse getTodo(Long todoId) {
        return todoService.getTodo(todoId);
    }

    @Transactional(readOnly = true)
    public Page<TodoWithCommentCountResponse> getTodos(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("updatedAt").descending()
        );
        return todoService.getTodos(pageRequest);
    }

    @Transactional
    public TodoResponse update(Long userId, Long todoId, UpdateTodoRequest request) {
        return todoService.update(userId,todoId,request);
    }

    @Transactional
    public void delete(Long userId, Long todoId) {
        todoService.delete(userId,todoId);
        commentService.deleteAllByTodoId(todoId);
    }
}
