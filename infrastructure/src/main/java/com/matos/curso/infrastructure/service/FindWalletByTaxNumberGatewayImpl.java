package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.FindWalletByTaxNumberGateway;
import com.matos.curso.core.domain.Wallet;
import com.matos.curso.infrastructure.mapper.WalletMapper;
import com.matos.curso.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import static com.matos.curso.infrastructure.utils.Utilities.log;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception {
        log.info("Inicio da busca da carteira::FindWalletByTaxNumberGatewayImpl");
        return walletMapper.toWallet(walletEntityRepository.findByUserEntityTaxNumber(taxNumber));
    }
}
