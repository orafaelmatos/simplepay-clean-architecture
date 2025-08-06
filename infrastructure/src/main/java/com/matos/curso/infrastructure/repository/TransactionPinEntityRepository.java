package com.matos.curso.infrastructure.repository;

import com.matos.curso.infrastructure.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
