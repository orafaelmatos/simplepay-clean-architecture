package com.matos.curso.usecase;

import com.matos.curso.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(String taxNumber) throws Exception;
}
