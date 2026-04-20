package com.example.clean_pedidos.adapter.in.web;

import com.example.clean_pedidos.domain.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleDomain(DomainException ex) {
        return Map.of("error", ex.getMessage());
    }
}