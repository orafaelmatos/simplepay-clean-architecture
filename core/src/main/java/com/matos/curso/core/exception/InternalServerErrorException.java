package com.matos.curso.core.exception;

public class InternalServerErrorException extends RuntimeException {
    private String code;

    public InternalServerErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
