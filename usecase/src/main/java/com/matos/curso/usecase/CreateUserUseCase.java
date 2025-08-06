package com.matos.curso.usecase;

import com.matos.curso.core.domain.User;
import com.matos.curso.core.exception.EmailException;
import com.matos.curso.core.exception.TaxNumberException;
import com.matos.curso.core.exception.TransactionPinException;

public interface CreateUserUseCase  {
    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException;
}
