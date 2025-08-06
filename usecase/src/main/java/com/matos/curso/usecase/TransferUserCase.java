package com.matos.curso.usecase;

import com.matos.curso.core.domain.Transaction;
import com.matos.curso.core.domain.User;
import com.matos.curso.core.domain.Wallet;
import com.matos.curso.core.exception.NotificationException;
import com.matos.curso.core.exception.PinException;
import com.matos.curso.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUserCase {
    Boolean transfer(Transaction transaction) throws Exception;
}
