package com.example.todo.todo.controller;

import com.example.todo.todo.service.TodoService;
import com.example.todo.todo.dto.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;
    private TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping
    public ResponseEntity<TodoCreateResponse> create(
            @RequestBody TodoCreateRequest request
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
    public ResponseEntity<List<TodoResponse>> getTodos(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updatedAt,
            @RequestParam(required = false) String authorName
            ) {
        return new ResponseEntity<>(todoService.findAll(updatedAt, authorName), HttpStatus.OK);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TodoUpdateResponse> update(
            @PathVariable Long todoId,
            @RequestBody TodoUpdateRequest request
            ) {
        return new ResponseEntity<>(todoService.update(todoId,request),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete (
            @RequestBody TodoDeleteRequest request
            ) {
        todoService.delete(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
