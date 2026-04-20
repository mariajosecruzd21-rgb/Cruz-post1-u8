package com.example.clean_pedidos.usecase;

import com.example.clean_pedidos.usecase.impl.CrearPedidoService;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;
import com.example.clean_pedidos.adapter.in.web.dto.LineaPedidoDto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;

class CrearPedidoServiceTest {

    @Test
    void debe_guardar_pedido_correctamente() {

        PedidoRepositoryPort repo = mock(PedidoRepositoryPort.class);

        CrearPedidoService service = new CrearPedidoService(repo);

        List<LineaPedidoDto> lineas = List.of(
                new LineaPedidoDto("Laptop", 1, BigDecimal.valueOf(1000))
        );

        service.ejecutar("Ana", lineas);

        verify(repo, times(1)).guardar(any());
    }
}