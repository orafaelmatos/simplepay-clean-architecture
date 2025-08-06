package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.TransactionValidateGateway;
import com.matos.curso.core.domain.Transaction;
import com.matos.curso.infrastructure.client.apivalidate.ApiValidateService;
import org.springframework.stereotype.Service;
import static com.matos.curso.infrastructure.utils.Utilities.log;

@Service
public class TransactionValidateGatewayImpl implements TransactionValidateGateway {
    private final ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        log.info("Inicio da validação da transação por serviço externo::TransactionValidateGatewayImpl");
        var response = apiValidateService.validate();
        if (response == null){
            log.error("Transação rejeitada::TransactionValidateGatewayImpl");
            return false;
        }
        log.info("Transação aceita::TransactionValidateGatewayImpl");
        return response.success();
    }
}
