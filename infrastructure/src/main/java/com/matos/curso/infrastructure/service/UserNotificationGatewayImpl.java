package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.UserNotificationGateway;
import com.matos.curso.core.domain.Transaction;
import com.matos.curso.infrastructure.client.usernotificate.NotificateClientService;
import org.springframework.stereotype.Service;
import static com.matos.curso.infrastructure.utils.Utilities.log;
@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    private NotificateClientService notificateService;

    public UserNotificationGatewayImpl(NotificateClientService notificateService) {
        this.notificateService = notificateService;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        log.info("Iniciando processo de notificação do usuário::UserNotificationGatewayImpl");
        var response = notificateService.notificate();
        if (response == true){
            log.info("Usuário notificado com sucesso::UserNotificationGatewayImpl");
        }
        return response;
    }
}