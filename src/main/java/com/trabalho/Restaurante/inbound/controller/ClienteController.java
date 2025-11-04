package com.trabalho.Restaurante.inbound.controller;

import com.trabalho.Restaurante.core.entity.Cliente;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        try {
            Cliente novo = clienteService.cadastrar(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(novo);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            clienteService.excluir(id);
            return ResponseEntity.ok("Cliente excluído com sucesso");
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
