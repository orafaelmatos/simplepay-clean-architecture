package com.matos.curso.infrastructure.mapper;

import com.matos.curso.core.domain.Transaction;
import com.matos.curso.core.domain.enums.TransactionStatusEnum;
import com.matos.curso.infrastructure.entity.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    private WalletMapper walletMapper;

    public TransactionMapper(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntity(transaction.getFromWallet()),
                walletMapper.toWalletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreateAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity createTransaction(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CREATED,
                transaction.getCreateAt(),
                transaction.getUpdateAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {
        return new Transaction(
                transactionEntity.getId(),
                walletMapper.toWallet(transactionEntity.getFromWallet()),
                walletMapper.toWallet(transactionEntity.getToWallet()),
                transactionEntity.getValue(),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdateAt()
        );
    }

    public TransactionEntity concludeTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.SUCCESS,
                transaction.getCreateAt(),
                transaction.getUpdateAt()
        );
    }

    public TransactionEntity cancelTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWalletEntityUpdate(transaction.getFromWallet()),
                walletMapper.toWalletEntityUpdate(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CANCELED,
                transaction.getCreateAt(),
                transaction.getUpdateAt()
        );
    }
}
