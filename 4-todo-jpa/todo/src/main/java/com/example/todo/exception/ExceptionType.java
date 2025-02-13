package com.example.todo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionType {

    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "요청값 검증에 실패했습니다."),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "해당 이메일로 가입한 계정이 존재합니다."),
    EMAIL_NOT_EXIST(HttpStatus.BAD_REQUEST, "해당 이메일로 가입한 계정이 없습니다."),
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),

    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "로그인 정보가 올바르지 않습니다."),

    NO_PERMISSION_ACTION(HttpStatus.FORBIDDEN, "권한이 없는 작업입니다."),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 사용자를 찾을 수 없습니다."),
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 일정을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 댓글을 찾을 수 없습니다."),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 문제가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ExceptionType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
