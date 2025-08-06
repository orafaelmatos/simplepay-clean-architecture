package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.EmailAvailableGateway;
import com.matos.curso.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;
import static com.matos.curso.infrastructure.utils.Utilities.log;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        log.info("Verificação de email disponível::EmailAvailableGatewayImpl");
        return !userEntityRepository.existsByEmail(email);
    }
}
