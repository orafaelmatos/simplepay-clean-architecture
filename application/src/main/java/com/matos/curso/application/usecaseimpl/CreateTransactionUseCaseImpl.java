package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.CreateTransactionGateway;
import com.matos.curso.core.domain.Transaction;
import com.matos.curso.core.domain.Wallet;
import com.matos.curso.core.exception.TransferException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.CreateTransactionUseCase;

import java.math.BigDecimal;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Wallet from, Wallet to, BigDecimal value) throws Exception {
        var transaction = new Transaction(from, to, value);
        var transactionSaved = createTransactionGateway.create(transaction);
        if (transactionSaved == null){
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        return transactionSaved;
    }
}
