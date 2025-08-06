package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.UpdateTransactionPinGateway;
import com.matos.curso.core.domain.TransactionPin;
import com.matos.curso.infrastructure.mapper.TransactionPinMapper;
import com.matos.curso.infrastructure.repository.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;
import static com.matos.curso.infrastructure.utils.Utilities.log;

@Service
public class UpdateTransactionPinGatewayImpl implements UpdateTransactionPinGateway {
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final TransactionPinMapper transactionPinMapper;

    public UpdateTransactionPinGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
    }

    @Override
    public TransactionPin update(TransactionPin transactionPin) {
        log.info("Inicia atualização da senha de transação::UpdateTransactionPinGatewayImpl");
        return transactionPinMapper.toTransactionPin(transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntityUpdate(transactionPin)));
    }
}
