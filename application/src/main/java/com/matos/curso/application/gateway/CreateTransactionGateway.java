package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction) throws Exception;
}
