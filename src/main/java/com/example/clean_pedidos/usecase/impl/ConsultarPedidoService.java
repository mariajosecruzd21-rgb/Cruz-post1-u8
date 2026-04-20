package com.example.clean_pedidos.usecase.impl;

import com.example.clean_pedidos.adapter.in.web.dto.PedidoResponse;
import com.example.clean_pedidos.domain.valueobject.PedidoId;
import com.example.clean_pedidos.usecase.ConsultarPedidoUseCase;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;
import com.example.clean_pedidos.domain.exception.DomainException;

import java.util.List;
import java.util.stream.Collectors;

public class ConsultarPedidoService implements ConsultarPedidoUseCase {

    private final PedidoRepositoryPort repo;

    public ConsultarPedidoService(PedidoRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public PedidoResponse buscarPorId(PedidoId id) {
        return repo.buscarPorId(id)
                .map(PedidoResponse::fromDomain)
                .orElseThrow(() -> new DomainException("Pedido no encontrado"));
    }

    @Override
    public List<PedidoResponse> listarTodos() {
        return repo.buscarTodos()
                .stream()
                .map(PedidoResponse::fromDomain)
                .collect(Collectors.toList());
    }
}