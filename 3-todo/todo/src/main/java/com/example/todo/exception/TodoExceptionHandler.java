package com.example.todo.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class TodoExceptionHandler extends ResponseEntityExceptionHandler {
    public TodoExceptionHandler() {
        super();
    }

    @ExceptionHandler(TodoException.class)
    public ResponseEntity<ErrorResponse> handleTodoException(TodoException e) {
        log.debug("Todo Custom Exception [statusCode = {}, errorMessage = {}, cause = {}]",
                e.getHttpStatus(), e.getMessage(), e.getStackTrace());
        return ResponseEntity.status(e.getHttpStatus())
                .body(ErrorResponse.from(e));
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid( /* @Valid 검증 오류 */
            MethodArgumentNotValidException e,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        ExceptionType exceptionType = ExceptionType.REQUEST_VALIDATION_FAILED;

        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> "["+error.getField()+"] " + error.getDefaultMessage())
                .toList();

        log.debug("Validation Exception [uri = { }, errorMessage = {}, cause = {}]",
                request.getContextPath(), e.getMessage(), e.getCause());
        return ResponseEntity.status(exceptionType.getHttpStatus())
                .body(new ErrorResponse(exceptionType, String.join(", ",errors)));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Server exception [errorMessage = {}, cause = {}]",
                e.getMessage(), e.getCause());
        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(ExceptionType.INTERNAL_SERVER_ERROR,
                        ExceptionType.INTERNAL_SERVER_ERROR.getMessage()));
    }

}
