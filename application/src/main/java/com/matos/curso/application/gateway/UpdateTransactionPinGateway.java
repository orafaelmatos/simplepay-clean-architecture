package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.TransactionPin;

public interface UpdateTransactionPinGateway {
    TransactionPin update(TransactionPin transactionPin);
}
