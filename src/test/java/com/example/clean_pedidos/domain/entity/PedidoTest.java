package com.example.clean_pedidos.domain.entity;

import com.example.clean_pedidos.domain.valueobject.*;
import com.example.clean_pedidos.domain.exception.DomainException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void crearPedido_y_confirmar_correctamente() {
        Pedido pedido = new Pedido(PedidoId.nuevo(), "Ana");

        pedido.agregarLinea("Laptop", 1, new Dinero(BigDecimal.valueOf(1000)));

        pedido.confirmar();

        assertEquals(EstadoPedido.CONFIRMADO, pedido.getEstado());
        assertEquals(1, pedido.getLineas().size());
    }

    @Test
    void no_se_puede_confirmar_sin_lineas() {
        Pedido pedido = new Pedido(PedidoId.nuevo(), "Ana");

        assertThrows(DomainException.class, pedido::confirmar);
    }
}