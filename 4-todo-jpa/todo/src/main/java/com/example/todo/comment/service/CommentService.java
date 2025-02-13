package com.example.todo.comment.service;

import com.example.todo.comment.domain.Comment;
import com.example.todo.comment.dto.CommentResponse;
import com.example.todo.comment.dto.CreateCommentRequest;
import com.example.todo.comment.dto.UpdateCommentRequest;
import com.example.todo.comment.repository.CommentRepository;
import com.example.todo.exception.CustomException;
import com.example.todo.exception.ExceptionType;
import com.example.todo.todo.domain.Todo;
import com.example.todo.todo.service.TodoService;
import com.example.todo.user.domain.User;
import com.example.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final TodoService todoService;

    @Transactional
    public CommentResponse create(Long userId, CreateCommentRequest request) {
        User user = userService.getUserById(userId);
        Todo todo = todoService.getTodoById(request.getTodoId());
        Comment comment = commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .user(user)
                        .todo(todo)
                        .build()
        );

        return CommentResponse.from(comment);
    }

    @Transactional(readOnly = true)
    public CommentResponse getComment(Long commentId) {
        return CommentResponse.from(getCommentById(commentId));
    }

    @Transactional
    public CommentResponse update(Long userId, Long commentId, UpdateCommentRequest request) {
        Comment comment = getCommentById(commentId);
        if(!comment.getUser().getId().equals(userId)) {
            throw new CustomException(ExceptionType.NO_PERMISSION_ACTION);
        }

        comment.update(request.getContent());
        return CommentResponse.from(comment);
    }

    @Transactional
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

