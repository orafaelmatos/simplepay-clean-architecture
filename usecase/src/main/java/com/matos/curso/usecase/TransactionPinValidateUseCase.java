package com.matos.curso.usecase;

import com.matos.curso.core.domain.TransactionPin;
import com.matos.curso.core.exception.PinException;
import com.matos.curso.core.exception.TransferException;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin, String pin) throws TransferException, PinException;
}
