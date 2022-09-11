package com.converter.unit.dto.response;

public class AppError {
    private final String message;

    public AppError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
