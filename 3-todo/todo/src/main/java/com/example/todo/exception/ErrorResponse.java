package com.example.todo.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private ExceptionType exceptionType;
    private String message;

    public ErrorResponse(ExceptionType exceptionType, String message) {
        this.exceptionType = exceptionType;
        this.message = message;
    }

    public static ErrorResponse from(TodoException e) {
        return new ErrorResponse(e.getExceptionType(), e.getMessage());
    }
}
