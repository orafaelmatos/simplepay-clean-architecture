package com.matos.curso.usecase;

import com.matos.curso.core.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
