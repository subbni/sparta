package com.example.todo.global.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


public class Paging {
    @Getter
    @AllArgsConstructor
    public static class Request {
        private int size;
        private int page;
    }

    @Getter
    @Builder
    public static class Response {
        private Object[] data;
        private int size;
        private int page;
    }
}
