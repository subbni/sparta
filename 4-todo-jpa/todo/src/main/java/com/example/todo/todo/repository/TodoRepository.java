package com.example.todo.todo.repository;

import com.example.todo.todo.domain.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Override
    Page<Todo> findAll(Pageable pageable);

    @Modifying
    @Query(
            value = "UPDATE todos SET deleted_at = NOW() WHERE user_id = ?",
            nativeQuery = true
    )
    @NativeQuery()
    void softDeleteByUserId(Long userId);
}
