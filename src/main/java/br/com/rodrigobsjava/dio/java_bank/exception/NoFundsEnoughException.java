package br.com.rodrigobsjava.dio.java_bank.exception;

public class NoFundsEnoughException extends RuntimeException {

    public NoFundsEnoughException(String message) {
        super(message);
    }

}