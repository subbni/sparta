package com.example.todo.controller;

import com.example.todo.controller.dto.TodoCreateRequest;
import com.example.todo.controller.dto.TodoCreateResponse;
import com.example.todo.controller.dto.TodoResponse;
import com.example.todo.service.TodoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;
    private TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostMapping
    public ResponseEntity<TodoCreateResponse> createTodo(
            @RequestBody TodoCreateRequest requestDto
            ) {
        return new ResponseEntity<>(todoService.saveTodo(requestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> findById(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(todoService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> findAll(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate updatedAt,
            @RequestParam(required = false) String authorName
            ) {
        return new ResponseEntity<>(todoService.findAll(updatedAt, authorName), HttpStatus.OK);
    }

}
