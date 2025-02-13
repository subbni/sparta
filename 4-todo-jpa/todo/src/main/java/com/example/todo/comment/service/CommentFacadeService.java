package com.example.todo.comment.service;

import com.example.todo.comment.dto.CommentResponse;
import com.example.todo.comment.dto.CreateCommentRequest;
import com.example.todo.comment.dto.UpdateCommentRequest;
import com.example.todo.todo.domain.Todo;
import com.example.todo.todo.service.TodoService;
import com.example.todo.user.domain.User;
import com.example.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentFacadeService {

    private CommentService commentService;
    private UserService userService;
    private TodoService todoService;

    @Transactional
    public CommentResponse create(Long userId, CreateCommentRequest request) {
        User user = userService.getUserById(userId);
        Todo todo = todoService.getTodoById(request.getTodoId());
        return commentService.create(user,todo,request);
    }

    @Transactional(readOnly = true)
    public CommentResponse getComment(Long commentId) {
        return commentService.getComment(commentId);
    }

    @Transactional
    public CommentResponse update(Long userId, Long commentId, UpdateCommentRequest request) {
        return commentService.update(userId,commentId,request);
    }

    @Transactional
    public void delete(Long userId, Long commentId) {
        commentService.delete(userId,commentId);
    }
}
