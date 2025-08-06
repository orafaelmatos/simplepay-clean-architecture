package com.matos.curso.usecase;

import com.matos.curso.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
