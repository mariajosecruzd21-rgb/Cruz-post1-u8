package com.example.clean_pedidos.usecase.port;

import com.example.clean_pedidos.domain.entity.Pedido;
import com.example.clean_pedidos.domain.valueobject.PedidoId;

import java.util.*;

public interface PedidoRepositoryPort {
    void guardar(Pedido pedido);
    Optional<Pedido> buscarPorId(PedidoId id);
    List<Pedido> buscarTodos();
}