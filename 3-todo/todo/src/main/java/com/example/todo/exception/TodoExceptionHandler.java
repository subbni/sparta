package com.example.todo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class TodoExceptionHandler {
    @ExceptionHandler(TodoException.class)
    public ResponseEntity<ErrorResponse> handleTodoException(TodoException e) {
        log.debug("Todo Custom Exception [statusCode = {}, errorMessage = {}, cause = {}]", e.getHttpStatus(), e.getMessage(), e.getStackTrace());
        return ResponseEntity.status(e.getHttpStatus())
                .body(ErrorResponse.from(e));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Server exception [errorMessage = {}, cause = {},error ={}]", e.getMessage(), e.getCause(), e.getStackTrace());
        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(ExceptionType.INTERNAL_SERVER_ERROR, ExceptionType.INTERNAL_SERVER_ERROR.getMessage()));
    }

}
