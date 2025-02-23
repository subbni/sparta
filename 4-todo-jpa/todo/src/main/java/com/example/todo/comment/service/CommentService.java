package com.example.todo.comment.service;

import com.example.todo.comment.domain.Comment;
import com.example.todo.comment.dto.CommentResponse;
import com.example.todo.comment.dto.CreateCommentRequest;
import com.example.todo.comment.dto.UpdateCommentRequest;
import com.example.todo.comment.repository.CommentRepository;
import com.example.todo.exception.CustomException;
import com.example.todo.exception.ExceptionType;
import com.example.todo.todo.domain.Todo;
import com.example.todo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentResponse create(User user, Todo todo, CreateCommentRequest request) {
        Comment comment = commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .user(user)
                        .todo(todo)
                        .build()
        );

        return CommentResponse.from(comment);
    }

    public CommentResponse getComment(Long commentId) {
        return CommentResponse.from(getCommentById(commentId));
    }

    public CommentResponse update(Long userId, Long commentId, UpdateCommentRequest request) {
        Comment comment = getCommentById(commentId);
        if(!comment.getUser().getId().equals(userId)) {
            throw new CustomException(ExceptionType.NO_PERMISSION_ACTION);
        }

        comment.update(request.getContent());
        return CommentResponse.from(comment);
    }

    public void delete(Long userId, Long commentId) {
        Comment comment = getCommentById(commentId);
        if(!comment.getUser().getId().equals(userId)) {
            throw new CustomException(ExceptionType.NO_PERMISSION_ACTION);
        }

        commentRepository.delete(comment);
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(()-> {
                    throw new CustomException(ExceptionType.COMMENT_NOT_FOUND);
                });
    }

    public void deleteAllByTodoId(Long todoId) {
        commentRepository.deleteAllByTodoId(todoId);
    }

    public void softDeleteByUserId(Long userId) {
        commentRepository.softDeleteByUserId(userId);
    }
}

