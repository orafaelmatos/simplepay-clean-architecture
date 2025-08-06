package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.EmailAvailableGateway;
import com.matos.curso.core.exception.EmailException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    private EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailableEmail(String email) throws EmailException {
        if (!emailAvailableGateway.emailAvailable(email)) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }
        return true;
    }
}
