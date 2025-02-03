package com.example.todo.todo.repository;

import com.example.todo.global.pagination.Paging;
import com.example.todo.todo.dto.TodoDetail;
import com.example.todo.todo.domain.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TodoRepository {
    Long saveAndReturnKey(Todo todo);
    Optional<TodoDetail> findById(Long id);
    List<TodoDetail> findAllByUserIdAndUpdatedAt(Long userId, LocalDate updatedAt, Paging.Request pagingRequest);
    void updateContent(Long id, String content);
    void delete(Long id);
}
