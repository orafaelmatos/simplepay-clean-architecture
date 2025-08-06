package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
