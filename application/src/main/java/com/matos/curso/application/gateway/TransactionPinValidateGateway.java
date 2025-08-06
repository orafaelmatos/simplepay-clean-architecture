package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {
    Boolean validate(TransactionPin transactionPin, String pin);
}
