package com.matos.curso.infrastructure.service;

import com.matos.curso.application.gateway.CreateUserGateway;
import com.matos.curso.core.domain.User;
import com.matos.curso.core.domain.Wallet;
import com.matos.curso.infrastructure.mapper.TransactionPinMapper;
import com.matos.curso.infrastructure.mapper.UserMapper;
import com.matos.curso.infrastructure.mapper.WalletMapper;
import com.matos.curso.infrastructure.repository.TransactionPinEntityRepository;
import com.matos.curso.infrastructure.repository.UserEntityRepository;
import com.matos.curso.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.matos.curso.infrastructure.utils.Utilities.log;
@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    final private UserEntityRepository userEntityRepository;
    final private UserMapper userMapper;
    final private WalletMapper walletMapper;
    final private TransactionPinMapper transactionPinMapper;
    final private WalletEntityRepository walletEntityRepository;
    final private TransactionPinEntityRepository transactionPinEntityRepository;
    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, WalletMapper walletMapper, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, TransactionPinEntityRepository transactionPinEntityRepository) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.walletMapper = walletMapper;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {
        try {
            log.info("Inicio da criação do usuário::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            log.info("Usuário criado com sucesso::CreateUserGatewayImpl");
            return true;
        } catch (Exception e){
            log.error("Houve um erro na criação do usuário::CreateUserGatewayImpl", e);
            return false;
        }
    }
}
