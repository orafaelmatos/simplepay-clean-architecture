package com.matos.curso.application.usecaseimpl;

import com.matos.curso.application.gateway.TaxNumberAvailableGateway;
import com.matos.curso.core.exception.TaxNumberException;
import com.matos.curso.core.exception.enums.ErrorCodeEnum;
import com.matos.curso.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {
    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException {
        if (!taxNumberAvailableGateway.taxNumberAvailable(taxNumber)){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }
        return true;
    }
}
