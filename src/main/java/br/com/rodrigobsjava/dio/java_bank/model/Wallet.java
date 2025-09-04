package br.com.rodrigobsjava.dio.java_bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@ToString
public abstract class Wallet {
    @Getter
    private final BankServiceType serviceType;

    protected List<Money> monies;

    public Wallet (final BankServiceType serviceType){
        this.serviceType = serviceType;
        this.monies = new ArrayList<>();
    }

    protected List<Money> generateMoney (final long amount, final String description){
        var history = new MoneyAudit(UUID.randomUUID(), serviceType, description, OffsetDateTime.now());
        return Stream.generate(() -> new Money(history)).limit(amount).toList();
    }

    public long getFunds(){
        return monies.size();
    }

    public void addMoney(final List<Money> money, final BankServiceType serviceType, final String description){
        var history = new MoneyAudit(UUID.randomUUID(), serviceType, description, OffsetDateTime.now());
        money.forEach(m -> m.addHistory(history));
        this.monies.addAll(money);
    }

    public List<Money> reduceMoney(final long amount) {
        List<Money> toRemove = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            toRemove.add(this.monies.removeFirst());
        }
        return toRemove;
    }

    public List<MoneyAudit> getFinancialTransactions() {
        return monies.stream().flatMap(money -> money.getHistory().stream()).toList();
    }
}
