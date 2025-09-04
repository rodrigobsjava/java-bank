package br.com.rodrigobsjava.dio.java_bank.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record MoneyAudit (
        UUID transactionId,
        BankServiceType targetService,
        String description,
        OffsetDateTime createdAt
){
}
