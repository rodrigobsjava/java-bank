package br.com.rodrigobsjava.dio.java_bank.repository;

import br.com.rodrigobsjava.dio.java_bank.exception.NoFundsEnoughException;
import br.com.rodrigobsjava.dio.java_bank.model.BankServiceType;
import br.com.rodrigobsjava.dio.java_bank.model.Money;
import br.com.rodrigobsjava.dio.java_bank.model.MoneyAudit;
import br.com.rodrigobsjava.dio.java_bank.model.Wallet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonsRepository {

    public static void checkFundsForTransaction(final Wallet source, final long amount){
        if(source.getFunds() < amount){
            throw new NoFundsEnoughException("Sua conta não tem dinheiro o suficiente para realizar essa transação");
        }
    }

    public static List<Money> generateMoney(final UUID transactionId, final long funds, final String description){
        var history = new MoneyAudit(transactionId, BankServiceType.ACCOUNT, description, OffsetDateTime.now());
        return Stream.generate(() -> new Money(history)).limit(funds).toList();
    }

}
