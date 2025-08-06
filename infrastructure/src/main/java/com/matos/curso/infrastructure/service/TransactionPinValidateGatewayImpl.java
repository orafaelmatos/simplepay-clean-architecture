package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.TransactionPinValidateGateway;
import com.matos.curso.core.domain.TransactionPin;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.matos.curso.infrastructure.utils.Utilities.log;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {
    @Override
    public Boolean validate(TransactionPin transactionPin, String pin) {
        log.info("Inicio da validação da senha de transação:TransactionPinValidateGatewayImpl");
        if (!Objects.equals(transactionPin.getPin(), pin)){
            log.error("Senha incorreta:TransactionPinValidateGatewayImpl");
            return false;
        }
        log.info("Senha correta:TransactionPinValidateGatewayImpl");
        return true;
    }
}
