package com.example.todo.todo.repository;

import com.example.todo.todo.dto.TodoUpdateRequest;
import com.example.todo.todo.domain.Todo;

import java.time.LocalDate;
import java.util.List;


public interface TodoRepository {
    Long saveAndReturnKey(Todo todo);
    Todo findByIdOrElseThrow(Long id);
    List<Todo> findAllByUpdatedAtAndAuthorName(LocalDate updateAt, String authorName);
    void update(TodoUpdateRequest updateRequest);
    void deleteById(Long id);
}
