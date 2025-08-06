package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.FindWalletByTaxNumberGateway;
import com.matos.curso.core.domain.Wallet;
import com.matos.curso.core.exception.NotFoundException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        var wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if (wallet == null){
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
