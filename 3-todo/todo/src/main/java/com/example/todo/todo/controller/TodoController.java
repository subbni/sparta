package com.example.todo.todo.controller;

import com.example.todo.global.pagination.Paging;
import com.example.todo.todo.service.TodoService;
import com.example.todo.todo.dto.*;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;
    private TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping
    public ResponseEntity<TodoSimpleResponse> create(
            @RequestBody @Valid TodoCreateRequest request
            ) {
        return new ResponseEntity<>(todoService.save(request), HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoResponse> getTodoById(
            @PathVariable Long todoId
    ) {
        return new ResponseEntity<>(todoService.findById(todoId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Paging.Response> getTodos(
        @RequestParam(required = false) Long userId,
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updatedAt,
        @RequestParam(required = false, defaultValue = "10") int size,
        @RequestParam(required = false, defaultValue = "0") int page
    ) {
        return new ResponseEntity<>(todoService.findAll(userId, updatedAt, new Paging.Request(size,page)),HttpStatus.OK);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoSimpleResponse> update(
            @PathVariable Long todoId,
            @RequestBody @Valid TodoUpdateRequest request
            ) {
        return new ResponseEntity<>(todoService.update(todoId,request),HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> delete (
            @RequestBody @Valid TodoDeleteRequest request
            ) {
        todoService.delete(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
