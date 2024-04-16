package com.example.testandroid.util;

public abstract class ApiResponse<T> {
    private ApiResponse() {
    }

    public static final class Loading<T> extends ApiResponse<T> {
    }

    public static final class Success<T> extends ApiResponse<T> {
        private final T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    public static final class Failure<T> extends ApiResponse<T> {
        private final String errorMessage;
        private final int code;

        public Failure(String errorMessage, int code) {
            this.errorMessage = errorMessage;
            this.code = code;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public int getCode() {
            return code;
        }
    }
}