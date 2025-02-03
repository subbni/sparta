package com.example.todo.todo.repository;

import com.example.todo.todo.dto.TodoDetail;
import com.example.todo.todo.dto.TodoUpdateRequest;
import com.example.todo.todo.domain.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TodoRepository {
    Long saveAndReturnKey(Todo todo);
    Optional<TodoDetail> findById(Long id);
    List<TodoDetail> findAll();
    List<TodoDetail> findAllByUserIdAndUpdatedAt(Long userId, LocalDate updatedAt);
    void update(TodoUpdateRequest updateRequest);
    void updateContent(Long id, String content);
    void delete(Long id);
}
