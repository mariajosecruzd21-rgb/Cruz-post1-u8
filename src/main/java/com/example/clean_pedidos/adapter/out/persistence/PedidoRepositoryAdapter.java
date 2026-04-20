package com.example.clean_pedidos.adapter.out.persistence;

import com.example.clean_pedidos.domain.entity.Pedido;
import com.example.clean_pedidos.domain.valueobject.*;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository jpa;

    public PedidoRepositoryAdapter(PedidoJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void guardar(Pedido pedido) {
        jpa.save(toEntity(pedido));
    }

    @Override
    public Optional<Pedido> buscarPorId(PedidoId id) {
        return Optional.empty(); // simplificado para tarea
    }

    @Override
    public List<Pedido> buscarTodos() {
        return List.of();
    }

    private PedidoJpaEntity toEntity(Pedido p) {
        PedidoJpaEntity e = new PedidoJpaEntity();
        e.setId(p.getId().toString());
        e.setClienteNombre(p.getClienteNombre());
        e.setTotal(p.calcularTotal().cantidad());
        return e;
    }
}