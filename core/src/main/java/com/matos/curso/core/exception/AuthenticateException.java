package com.matos.curso.core.exception;

public class AuthenticateException extends Throwable {

    private String code;
    public AuthenticateException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
