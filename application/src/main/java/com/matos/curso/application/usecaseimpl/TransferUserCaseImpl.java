package com.matos.curso.application.usecaseimpl;


import com.matos.curso.application.gateway.TransferGateway;
import com.matos.curso.core.domain.Transaction;
import com.matos.curso.core.domain.User;
import com.matos.curso.core.domain.Wallet;

import com.matos.curso.core.exception.InternalServerErrorException;
import com.matos.curso.core.exception.NotificationException;
import com.matos.curso.core.exception.PinException;
import com.matos.curso.core.exception.TransferException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.*;

import java.math.BigDecimal;

public class TransferUserCaseImpl implements TransferUserCase {
    final private TransferGateway transferGateway;

    public TransferUserCaseImpl(TransferGateway transferGateway) {
        this.transferGateway = transferGateway;
    }


    @Override
    public Boolean transfer(Transaction transaction) throws Exception {
        transaction.getFromWallet().transfer(transaction.getValue());
        transaction.getToWallet().receiveTransfer(transaction.getValue());
        if (!transferGateway.transfer(transaction)){
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        return true;
    }
}
