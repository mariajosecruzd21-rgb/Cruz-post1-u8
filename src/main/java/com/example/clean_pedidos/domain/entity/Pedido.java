package com.example.clean_pedidos.domain.entity;

import com.example.clean_pedidos.domain.valueobject.*;
import com.example.clean_pedidos.domain.exception.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private final PedidoId id;
    private final String clienteNombre;
    private final List<LineaPedido> lineas = new ArrayList<>();
    private EstadoPedido estado = EstadoPedido.BORRADOR;

    public Pedido(PedidoId id, String clienteNombre) {
        this.id = Objects.requireNonNull(id);

        if (clienteNombre == null || clienteNombre.isBlank())
            throw new DomainException("Cliente obligatorio");

        this.clienteNombre = clienteNombre;
    }

    public void agregarLinea(String producto, int cantidad, Dinero precio) {

        if (estado != EstadoPedido.BORRADOR)
            throw new DomainException("Solo BORRADOR");

        if (cantidad <= 0)
            throw new DomainException("Cantidad inválida");

        lineas.add(new LineaPedido(producto, cantidad, precio));
    }

    public void confirmar() {
        if (lineas.isEmpty())
            throw new DomainException("Sin líneas");

        this.estado = EstadoPedido.CONFIRMADO;
    }

    public Dinero calcularTotal() {
        return lineas.stream()
                .map(LineaPedido::subtotal)
                .reduce(Dinero.CERO, Dinero::sumar);
    }

    public PedidoId getId() { return id; }
    public String getClienteNombre() { return clienteNombre; }
    public List<LineaPedido> getLineas() { return lineas; }
    public EstadoPedido getEstado() { return estado; }
}