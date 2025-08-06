package com.matos.curso.usecase;

import com.matos.curso.core.domain.Transaction;
import com.matos.curso.core.exception.TransferException;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws TransferException;
}
