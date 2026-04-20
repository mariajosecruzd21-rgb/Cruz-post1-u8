package com.example.clean_pedidos.domain.exception;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}