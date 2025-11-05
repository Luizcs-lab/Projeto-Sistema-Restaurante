package com.trabalho.Restaurante.inbound.controller;

import com.trabalho.Restaurante.core.entity.Funcionario;
import com.trabalho.Restaurante.core.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*") // permite que o frontend React acesse a API
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Funcionario funcionario) throws Exception {
        try {
            Funcionario autenticado = FuncionarioService.autenticar(funcionario.getEmail(), funcionario.getSenha());
            return ResponseEntity.ok(autenticado);
        } catch (com.trabalho.Restaurante.core.exception.BusinessException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    // Endpoint de cadastro
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Funcionario funcionario) throws Exception {
        try {
            Funcionario novo = funcionarioService.cadastrar(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novo);
        } catch (com.trabalho.Restaurante.core.exception.BusinessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
