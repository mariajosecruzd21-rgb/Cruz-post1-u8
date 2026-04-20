package com.example.clean_pedidos.adapter.out.persistence;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class PedidoJpaEntity {

    @Id
    private String id;

    private String clienteNombre;

    private BigDecimal total;

    // -------------------------
    // GETTERS
    // -------------------------

    public String getId() {
        return id;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public BigDecimal getTotal() {
        return total;
    }

    // -------------------------
    // SETTERS
    // -------------------------

    public void setId(String id) {
        this.id = id;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}