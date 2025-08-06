package com.matos.curso.infrastructure.entity;

import com.matos.curso.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Transactions")
public class TransactionEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FromWallet")
    private WalletEntity fromWallet;
    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletEntity toWallet;
    @Column(name = "TransactionValue", nullable = false)
    private BigDecimal value;
    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;
    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;

    public TransactionEntity(WalletEntity fromWallet, WalletEntity toWallet, BigDecimal value, TransactionStatusEnum status, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
