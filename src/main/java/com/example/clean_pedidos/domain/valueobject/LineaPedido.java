package com.example.clean_pedidos.domain.valueobject;

import java.math.BigDecimal;

public record LineaPedido(
        String productoNombre,
        int cantidad,
        Dinero precioUnitario
) {

    public Dinero subtotal() {
        return new Dinero(
                precioUnitario.cantidad()
                        .multiply(BigDecimal.valueOf(cantidad))
        );
    }
}