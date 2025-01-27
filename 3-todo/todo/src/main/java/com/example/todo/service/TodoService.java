package com.example.todo.service;

import com.example.todo.controller.dto.*;
import com.example.todo.entity.Todo;
import com.example.todo.exception.ExceptionType;
import com.example.todo.exception.TodoException;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoCreateResponse save(TodoCreateRequest request) {
        Todo todo = Todo.builder()
                .content(request.getContent())
                .authorName(request.getAuthorName())
                .password(request.getPassword())
                .build();
        Long generatedId = todoRepository.saveAndReturnKey(todo);
        return TodoCreateResponse.builder()
                .id(generatedId)
                .content(todo.getContent())
                .authorName(todo.getAuthorName())
                .build();
    }

    public TodoResponse findById(Long todoId) {
        Todo todo = todoRepository.findByIdOrElseThrow(todoId);
        return TodoResponse.fromEntity(todo);
    }

    public List<TodoResponse> findAll(LocalDate updatedAt, String authorName) {
        return todoRepository.findAllByUpdatedAtAndAuthorName(updatedAt, authorName)
                .stream()
                .map(TodoResponse::fromEntity)
                .toList();
    }

    public TodoUpdateResponse update(Long todoId, TodoUpdateRequest request) {
        Todo todo = todoRepository.findByIdOrElseThrow(todoId);
        checkPasswordMatch(todo,request.getPassword());
        todoRepository.update(request);
        return TodoUpdateResponse.builder()
                .id(request.getTodoId())
                .content(request.getContent())
                .authorName(request.getAuthorName())
                .build();
    }

    public void delete(TodoDeleteRequest request) {
        Todo todo = todoRepository.findByIdOrElseThrow(request.getId());
        checkPasswordMatch(todo, request.getPassword());
        todoRepository.deleteById(todo.getId());
    }

    private void checkPasswordMatch(Todo todo, String password) {
        if(!todo.getPassword().equals(password)) {
            throw new TodoException(ExceptionType.PASSWORD_NOT_MATCH);
        }
    }
}
