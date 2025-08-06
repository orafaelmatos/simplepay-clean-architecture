package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
