package br.com.rodrigobsjava.dio.java_bank.model;

import lombok.Getter;

import java.util.List;

@Getter
public class AccountWallet extends Wallet{

    private final List<String> pix;

    public AccountWallet(final List<String> pix) {
        super(BankServiceType.ACCOUNT);
        this.pix = pix;
    }
    public AccountWallet(final long amount,final List<String> pix) {
        super(BankServiceType.ACCOUNT);
        this.pix = pix;
        this.addMoney(amount, "valor de criação da conta");
    }

    public void addMoney(final long amount, final String description) {
        var money = generateMoney(amount, description);
        this.monies.addAll(money);
    }
}
