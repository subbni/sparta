package com.example.todo.todo.controller;

import com.example.todo.global.annotation.CurrentUserId;
import com.example.todo.todo.dto.CreateTodoRequest;
import com.example.todo.todo.dto.TodoResponse;
import com.example.todo.todo.dto.UpdateTodoRequest;
import com.example.todo.todo.service.TodoFacadeService;
import com.example.todo.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoFacadeService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(
            @CurrentUserId Long userId,
            @Valid @RequestBody CreateTodoRequest request
            ) {
        return new ResponseEntity<>(todoService.create(userId,request), HttpStatus.CREATED);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponse> getTodo(
            @PathVariable Long todoId
    ) {
        return new ResponseEntity<>(todoService.getTodo(todoId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<TodoResponse>> getTodos(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return new ResponseEntity<>(todoService.getTodos(PageRequest.of(page,size)), HttpStatus.OK);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoResponse> update(
            @CurrentUserId Long userId,
            @PathVariable Long todoId,
            @Valid @RequestBody UpdateTodoRequest request

    ) {
        return new ResponseEntity<>(todoService.update(userId, todoId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> delete(
            @CurrentUserId Long userId,
            @PathVariable Long todoId
    ) {
        todoService.delete(userId, todoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
