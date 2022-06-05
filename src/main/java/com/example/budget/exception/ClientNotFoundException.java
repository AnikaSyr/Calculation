package com.example.budget.exception;

public class ClientNotFoundException extends Throwable {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
