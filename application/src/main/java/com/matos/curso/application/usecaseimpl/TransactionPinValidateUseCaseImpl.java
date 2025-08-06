package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.TransactionPinValidateGateway;
import com.matos.curso.core.domain.TransactionPin;
import com.matos.curso.core.exception.PinException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.TransactionPinValidateUseCase;
import com.matos.curso.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    final private TransactionPinValidateGateway transactionPinValidateGateway;
    final private UpdateTransactionPinUseCase updateTransactionPinUseCase;
    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinUseCase updateTransactionPinUseCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) throws PinException {
        if (transactionPin.getBlocked()) throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());

        if (!transactionPinValidateGateway.validate(transactionPin, pin)){
            transactionPin.setAttempt();
            var transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() < 3){
            transactionPin.restaureAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return true;
    }
}
