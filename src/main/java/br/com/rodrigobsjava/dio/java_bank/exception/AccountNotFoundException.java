package br.com.rodrigobsjava.dio.java_bank.exception;


public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }

}
