package com.matos.curso.usecase;

import com.matos.curso.core.exception.EmailException;

public interface EmailAvailableUseCase {
    Boolean emailAvailableEmail(String email) throws EmailException;
}
