package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.UserNotificationGateway;
import com.matos.curso.core.domain.Transaction;
import com.matos.curso.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {
    private UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
