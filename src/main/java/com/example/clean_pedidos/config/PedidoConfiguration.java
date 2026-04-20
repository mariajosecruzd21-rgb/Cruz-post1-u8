package com.example.clean_pedidos.config;

import com.example.clean_pedidos.usecase.*;
import com.example.clean_pedidos.usecase.impl.*;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;

import org.springframework.context.annotation.*;

@Configuration
public class PedidoConfiguration {

    @Bean
    public CrearPedidoUseCase crear(PedidoRepositoryPort repo) {
        return new CrearPedidoService(repo);
    }

    @Bean
    public ConsultarPedidoUseCase consultar(PedidoRepositoryPort repo) {
        return new ConsultarPedidoService(repo);
    }
}