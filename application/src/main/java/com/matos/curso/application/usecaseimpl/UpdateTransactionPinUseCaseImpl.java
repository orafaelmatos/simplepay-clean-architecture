package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.UpdateTransactionPinGateway;
import com.matos.curso.core.domain.TransactionPin;
import com.matos.curso.usecase.UpdateTransactionPinUseCase;

public class UpdateTransactionPinUseCaseImpl implements UpdateTransactionPinUseCase {
    private final UpdateTransactionPinGateway updateTransactionPinGateway;

    public UpdateTransactionPinUseCaseImpl(UpdateTransactionPinGateway updateTransactionPinGateway) {
        this.updateTransactionPinGateway = updateTransactionPinGateway;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        return updateTransactionPinGateway.update(transactionPin);
    }
}
