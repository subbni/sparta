package com.example.todo.todo.service;

import com.example.todo.exception.CustomException;
import com.example.todo.exception.ExceptionType;
import com.example.todo.todo.domain.Todo;
import com.example.todo.todo.dto.CreateTodoRequest;
import com.example.todo.todo.dto.TodoResponse;
import com.example.todo.todo.dto.UpdateTodoRequest;
import com.example.todo.todo.repository.TodoRepository;
import com.example.todo.user.domain.User;
import com.example.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;

    @Transactional
    public TodoResponse create(Long userId, CreateTodoRequest request) {
        User user = userService.getUserById(userId);
        Todo todo = todoRepository.save(
                Todo.builder()
                        .user(user)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );

        return TodoResponse.from(todo);
    }

    @Transactional(readOnly = true)
    public TodoResponse getTodo(Long todoId) {
        return TodoResponse.from(getTodoById(todoId));
    }

    @Transactional(readOnly = true)
    public Page<TodoResponse> getTodos(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("updatedAt").descending()
        );

        return todoRepository.findAll(pageRequest)
                .map(TodoResponse::from);
    }

    @Transactional
    public TodoResponse update(Long userId, Long todoId, UpdateTodoRequest request) {
        Todo todo = getTodoById(todoId);
        if(!todo.getUser().getId().equals(userId)) {
            throw new CustomException(ExceptionType.NO_PERMISSION_ACTION);
        }

        todo.update(request.getTitle(), request.getContent());
        return TodoResponse.from(todo);
    }

    @Transactional
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
}
