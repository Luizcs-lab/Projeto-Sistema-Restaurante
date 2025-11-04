package com.trabalho.Restaurante.inbound.controller;

import com.trabalho.Restaurante.core.entity.Prato;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.service.PratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pratos")
@CrossOrigin(origins = "*")
public class PratoController {

    private final PratoService pratoService;

    public PratoController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Prato prato) {
        try {
            Prato novo = pratoService.cadastrar(prato);
            return ResponseEntity.status(HttpStatus.CREATED).body(novo);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<Prato> listar() {
        return pratoService.listar();
    }

    @PatchMapping("/{id}/disponivel/{status}")
    public ResponseEntity<?> alterarDisponibilidade(@PathVariable Long id, @PathVariable boolean status) {
        try {
            Prato atualizado = pratoService.alterarDisponibilidade(id, status);
            return ResponseEntity.ok(atualizado);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
