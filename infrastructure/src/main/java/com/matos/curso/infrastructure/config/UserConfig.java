package com.matos.curso.infrastructure.config;

import com.matos.curso.application.gateway.CreateUserGateway;
import com.matos.curso.application.gateway.EmailAvailableGateway;
import com.matos.curso.application.gateway.TaxNumberAvailableGateway;
import com.matos.curso.application.usecaseimpl.CreateUserUseCaseImpl;
import com.matos.curso.application.usecaseimpl.EmailAvailableUseCaseImpl;
import com.matos.curso.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import com.matos.curso.usecase.CreateUserUseCase;
import com.matos.curso.usecase.EmailAvailableUseCase;
import com.matos.curso.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway){
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }
    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway){
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }
    @Bean
    public CreateUserUseCase createUserUseCase(CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(createUserGateway);
    }
}
