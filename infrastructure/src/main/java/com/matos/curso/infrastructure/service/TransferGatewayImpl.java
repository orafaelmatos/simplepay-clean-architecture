package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.TransferGateway;
import com.matos.curso.core.domain.Transaction;
import com.matos.curso.infrastructure.mapper.TransactionMapper;
import com.matos.curso.infrastructure.mapper.WalletMapper;
import com.matos.curso.infrastructure.repository.TransactionEntityRepository;
import com.matos.curso.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.matos.curso.infrastructure.utils.Utilities.log;

@Service
public class TransferGatewayImpl implements TransferGateway {
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;
    private TransactionEntityRepository transactionEntityRepository;
    private TransactionMapper transactionMapper;
    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper, TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    @Transactional
    public Boolean transfer(Transaction transaction) {
        try {
            log.info("Inicio da transferência::TransferGatewayImpl");
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getFromWallet()));
            walletEntityRepository.save(walletMapper.toWalletEntityUpdate(transaction.getToWallet()));
            transactionEntityRepository.save(transactionMapper.concludeTransaction(transaction));
            log.info("Transferência concluída::TransferGatewayImpl");
            return true;
        } catch (Exception e) {
            transactionEntityRepository.save(transactionMapper.cancelTransaction(transaction));
            log.error("Transferência cancelada::TransferGatewayImpl");
            return false;
        }
    }
}
