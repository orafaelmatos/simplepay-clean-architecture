package com.matos.curso.infrastructure.repository;

import com.matos.curso.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByUserEntityTaxNumber(String taxNumber);
}
