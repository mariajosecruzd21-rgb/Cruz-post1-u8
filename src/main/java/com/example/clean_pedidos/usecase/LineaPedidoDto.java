package com.example.clean_pedidos.usecase;

import java.math.BigDecimal;

public record LineaPedidoDto(
        String productoNombre,
        int cantidad,
        BigDecimal precioUnitario
) {}