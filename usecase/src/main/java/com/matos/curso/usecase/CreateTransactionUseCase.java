package com.matos.curso.usecase;

import com.matos.curso.core.domain.Transaction;
import com.matos.curso.core.domain.Wallet;
import com.matos.curso.core.exception.TransferException;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {
    Transaction create(Wallet from, Wallet to, BigDecimal value) throws Exception;
}
