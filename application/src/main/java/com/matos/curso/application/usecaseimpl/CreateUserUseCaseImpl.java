package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.CreateUserGateway;
import com.matos.curso.core.domain.TransactionPin;
import com.matos.curso.core.domain.User;
import com.matos.curso.core.domain.Wallet;
import com.matos.curso.core.exception.EmailException;
import com.matos.curso.core.exception.InternalServerErrorException;
import com.matos.curso.core.exception.TaxNumberException;
import com.matos.curso.core.exception.TransactionPinException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException {

       if (!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))) {
           throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
