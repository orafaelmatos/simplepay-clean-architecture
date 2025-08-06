package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
