package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.UserAuthenticateGateway;
import com.matos.curso.core.exception.AuthenticateException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.UserAuthenticateUseCase;

import javax.security.sasl.AuthenticationException;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if (!userAuthenticateGateway.authenticate(username, password)){
            throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }
        return true;
    }
}
