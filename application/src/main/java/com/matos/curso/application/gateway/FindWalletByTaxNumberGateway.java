package com.matos.curso.application.gateway;

import com.matos.curso.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber) throws Exception;
}
