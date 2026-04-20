package com.example.clean_pedidos.usecase;

import com.example.clean_pedidos.adapter.in.web.dto.PedidoResponse;
import com.example.clean_pedidos.domain.valueobject.PedidoId;

import java.util.List;

public interface ConsultarPedidoUseCase {
    PedidoResponse buscarPorId(PedidoId id);
    List<PedidoResponse> listarTodos();
}