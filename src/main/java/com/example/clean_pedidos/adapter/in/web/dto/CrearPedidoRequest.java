package com.example.clean_pedidos.adapter.in.web.dto;

import java.util.List;

public record CrearPedidoRequest(
        String clienteNombre,
        List<LineaPedidoDto> lineas
) {}