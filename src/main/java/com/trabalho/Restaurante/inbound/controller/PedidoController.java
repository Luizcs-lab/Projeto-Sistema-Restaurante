package com.trabalho.Restaurante.inbound.controller;

import com.trabalho.Restaurante.core.entity.Pedido;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody Pedido pedido) {
        try {
            Pedido novo = PedidoService.criarPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novo);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<Pedido> listar() {
        return pedidoService.listarPedidos();
    }
}
