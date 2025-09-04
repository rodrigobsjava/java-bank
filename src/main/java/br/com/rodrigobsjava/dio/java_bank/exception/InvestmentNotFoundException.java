package br.com.rodrigobsjava.dio.java_bank.exception;

public class InvestmentNotFoundException extends RuntimeException{
    public InvestmentNotFoundException(String message){
        super(message);
    }
}
