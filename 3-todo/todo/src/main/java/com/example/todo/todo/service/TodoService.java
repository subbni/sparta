package com.example.todo.todo.service;

import com.example.todo.todo.domain.Todo;
import com.example.todo.exception.ExceptionType;
import com.example.todo.exception.TodoException;
import com.example.todo.todo.repository.TodoRepository;
import com.example.todo.todo.dto.*;
import com.example.todo.user.dto.UserCreateRequest;
import com.example.todo.user.dto.UserResponse;
import com.example.todo.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserService userService;

    public TodoService(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    public TodoSimpleResponse save(TodoCreateRequest request) {
        UserResponse userResponse = userService.findOrSave(UserCreateRequest.builder()
                        .name(request.getUserName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                .build());

        Todo todo = Todo.builder()
                .content(request.getContent())
                .userId(userResponse.getId())
                .password(request.getPassword())
                .build();

        Long generatedId = todoRepository.saveAndReturnKey(todo);
        return TodoSimpleResponse.builder()
                .id(generatedId)
                .content(todo.getContent())
                .userName(userResponse.getName())
                .build();
    }

    public TodoResponse findById(Long id) {
        return TodoResponse.from(todoRepository.findById(id)
                .orElseThrow(() -> new TodoException(ExceptionType.RESOURCE_NOT_FOUND)));
    }

    /** Lv.1 구현
    public List<TodoResponse> findAll(LocalDate updatedAt, String authorName) {
        return todoRepository.findAllByUpdatedAtAndAuthorName(updatedAt, authorName)
                .stream()
                .map(TodoResponse::fromEntity)
                .toList();
    }
     **/


    public List<TodoResponse> findAllByUserId(Long userId) {
        if(userId == null) {
            return todoRepository.findAll().stream().map(TodoResponse::from).toList();
        }
        return todoRepository.findAllByUserId(userId).stream().map(TodoResponse::from).toList();
    }

    public TodoSimpleResponse update(Long todoId, TodoUpdateRequest request) {
        TodoDetail todoDetail = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoException(ExceptionType.RESOURCE_NOT_FOUND));
        checkPasswordMatch(request.getPassword(),todoDetail.getPassword());

        todoRepository.update(request);
        userService.updateName(todoDetail.getUserId(),request.getUserName()); // TODO : userId가 유효한 지 검증 필요
        return TodoSimpleResponse.builder()
                .id(request.getTodoId())
                .content(request.getContent())
                .userName(request.getUserName())
                .build();
    }

    public void delete(TodoDeleteRequest request) {
        TodoDetail todoDetail = todoRepository.findById(request.getId())
                .orElseThrow(() -> new TodoException(ExceptionType.RESOURCE_NOT_FOUND));
        checkPasswordMatch(request.getPassword(),todoDetail.getPassword());
        todoRepository.delete(todoDetail.getId());
    }

    private void checkPasswordMatch(String inputPassword, String storedPassword) {
        if(!storedPassword.equals(inputPassword)) {
            throw new TodoException(ExceptionType.PASSWORD_NOT_MATCH);
        }
    }
}
