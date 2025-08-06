package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.User;
import com.matos.curso.core.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet);
}
