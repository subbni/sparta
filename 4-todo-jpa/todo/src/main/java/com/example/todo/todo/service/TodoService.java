package com.example.todo.todo.service;

import com.example.todo.exception.CustomException;
import com.example.todo.exception.ExceptionType;
import com.example.todo.todo.domain.Todo;
import com.example.todo.todo.dto.CreateTodoRequest;
import com.example.todo.todo.dto.TodoResponse;
import com.example.todo.todo.dto.TodoWithCommentCountResponse;
import com.example.todo.todo.dto.UpdateTodoRequest;
import com.example.todo.todo.repository.TodoRepository;
import com.example.todo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoResponse create(User user, CreateTodoRequest request) {
        Todo todo = todoRepository.save(
                Todo.builder()
                        .user(user)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );

        return TodoResponse.from(todo);
    }

    public TodoResponse getTodo(Long todoId) {
        return TodoResponse.from(getTodoById(todoId));
    }

    public Page<TodoWithCommentCountResponse> getTodos(Pageable pageable) {
        return todoRepository.findAll(pageable)
                .map(TodoWithCommentCountResponse::from);
    }

    public TodoResponse update(Long userId, Long todoId, UpdateTodoRequest request) {
        Todo todo = getTodoById(todoId);
        if(!todo.getUser().getId().equals(userId)) {
            throw new CustomException(ExceptionType.NO_PERMISSION_ACTION);
        }

        todo.update(request.getTitle(), request.getContent());
        return TodoResponse.from(todo);
    }

    public void delete(Long userId, Long todoId) {
        Todo todo = getTodoById(todoId);
        if(!todo.getUser().getId().equals(userId)) {
            throw new CustomException(ExceptionType.NO_PERMISSION_ACTION);
        }

        todoRepository.delete(todo);
    }

    public Todo getTodoById(Long todoId) {
        return todoRepository.findById(todoId)
                .orElseThrow(()-> {
                    throw new CustomException(ExceptionType.TODO_NOT_FOUND);
                });
    }

    public void softDeleteByUserId(Long userId) {
        todoRepository.softDeleteByUserId(userId);
    }
}
