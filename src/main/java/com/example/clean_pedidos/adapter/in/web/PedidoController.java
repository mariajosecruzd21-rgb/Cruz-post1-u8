package com.example.clean_pedidos.adapter.in.web;

import com.example.clean_pedidos.adapter.in.web.dto.*;
import com.example.clean_pedidos.domain.valueobject.PedidoId;
import com.example.clean_pedidos.usecase.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final CrearPedidoUseCase crear;
    private final ConsultarPedidoUseCase consultar;

    public PedidoController(CrearPedidoUseCase crear,
                            ConsultarPedidoUseCase consultar) {
        this.crear = crear;
        this.consultar = consultar;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> crear(@RequestBody CrearPedidoRequest req) {
        PedidoId id = crear.ejecutar(req.clienteNombre(), req.lineas());
        return Map.of("pedidoId", id.toString());
    }

    @GetMapping("/{id}")
    public PedidoResponse buscar(@PathVariable String id) {
        return consultar.buscarPorId(new PedidoId(UUID.fromString(id)));
    }

    @GetMapping
    public List<PedidoResponse> listar() {
        return consultar.listarTodos();
    }
}