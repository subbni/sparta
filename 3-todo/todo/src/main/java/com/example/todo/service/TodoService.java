package com.example.todo.service;

import com.example.todo.controller.dto.TodoCreateRequest;
import com.example.todo.controller.dto.TodoCreateResponse;
import com.example.todo.controller.dto.TodoResponse;
import com.example.todo.entity.Todo;
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

    public TodoCreateResponse saveTodo(TodoCreateRequest requestDto) {
        Todo todo = Todo.builder()
                .content(requestDto.getContent())
                .authorName(requestDto.getAuthorName())
                .password(requestDto.getPassword())
                .build();
        Long generatedId = todoRepository.saveAndReturnKey(todo);
        return TodoCreateResponse.builder()
                .id(generatedId)
                .content(todo.getContent())
                .authorName(todo.getAuthorName())
                .build();
    }

    public List<TodoResponse> findAll(LocalDate updatedAt, String authorName) {
        return todoRepository.findAllByUpdatedAtAndAuthorName(updatedAt, authorName)
                .stream()
                .map(TodoResponse::fromEntity)
                .toList();
    }
}
