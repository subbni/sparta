package com.example.todo.repository;

import com.example.todo.controller.dto.TodoUpdateRequest;
import com.example.todo.entity.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface TodoRepository {
    Long saveAndReturnKey(Todo todo);
    Todo findByIdOrElseThrow(Long id);
    List<Todo> findAllByUpdatedAtAndAuthorName(LocalDate updateAt, String authorName);
    void update(TodoUpdateRequest updateRequest);
    void deleteById(Long id);
}
