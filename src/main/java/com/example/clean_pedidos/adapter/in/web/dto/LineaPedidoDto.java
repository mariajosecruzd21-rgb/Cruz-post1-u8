package com.example.clean_pedidos.adapter.in.web.dto;

import java.math.BigDecimal;

public record LineaPedidoDto(
        String productoNombre,
        int cantidad,
        BigDecimal precioUnitario
) {}