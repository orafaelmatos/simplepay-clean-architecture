package com.matos.curso.core.exception;

public class BadRequestException extends RuntimeException {
    private String code;
    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
