package com.example.todo.comment.repository;

import com.example.todo.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    void deleteAllByTodoId(Long todoId);

    @Modifying
    @Query(
            value = "UPDATE comments SET deleted_at = NOW() WHERE user_id = ?",
            nativeQuery = true
    )
    void softDeleteByUserId(Long userId);
}
