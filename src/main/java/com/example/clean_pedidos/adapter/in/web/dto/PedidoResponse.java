package com.example.clean_pedidos.adapter.in.web.dto;

import com.example.clean_pedidos.domain.entity.Pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record PedidoResponse(
        String id,
        String cliente,
        BigDecimal total,
        List<LineaPedidoDto> lineas
) {
    public static PedidoResponse fromDomain(Pedido p) {
        return new PedidoResponse(
                p.getId().toString(),
                p.getClienteNombre(),
                p.calcularTotal().cantidad(),
                p.getLineas().stream()
                        .map(linea -> new LineaPedidoDto(
                                linea.productoNombre(),
                                linea.cantidad(),
                                linea.precioUnitario().cantidad()
                        ))
                        .collect(Collectors.toList())
        );
    }
}