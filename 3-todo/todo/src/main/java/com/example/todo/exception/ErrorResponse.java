package com.example.todo.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private ExceptionType type;
    private String detail;

    public ErrorResponse(ExceptionType type, String detail) {
        this.type = type;
        this.detail = detail;
    }

    public static ErrorResponse from(TodoException e) {
        return new ErrorResponse(e.getExceptionType(), e.getMessage());
    }
}
