package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.CreateTransactionGateway;
import com.matos.curso.core.domain.Transaction;
import com.matos.curso.infrastructure.mapper.TransactionMapper;
import com.matos.curso.infrastructure.repository.TransactionEntityRepository;
import org.springframework.stereotype.Service;
import static com.matos.curso.infrastructure.utils.Utilities.log;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction){
        try {
            log.info("Inicio da criação da transação::CreateTransactionGatewayImpl");
            var transactionEntity = transactionMapper.createTransaction(transaction);
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        } catch (Exception e) {
            log.error("Houve um erro ao criar transação::CreateTransactionGatewayImpl");
            return null;
        }
    }
}
