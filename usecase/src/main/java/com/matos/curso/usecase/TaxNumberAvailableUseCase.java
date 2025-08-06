package com.matos.curso.usecase;

import com.matos.curso.core.exception.TaxNumberException;

public interface TaxNumberAvailableUseCase {
    Boolean taxNumberAvailable(String taxNumber) throws TaxNumberException;
}
