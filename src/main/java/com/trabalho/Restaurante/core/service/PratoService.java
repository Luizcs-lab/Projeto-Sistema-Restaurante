package com.trabalho.Restaurante.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trabalho.Restaurante.core.entity.Prato;
import com.trabalho.Restaurante.core.repository.PratoRepository;

// ... imports

@Service
public class PratoService {

    private final PratoRepository pratoRepository = null;

    // ... construtor

    // CORREÇÃO: Removido 'static'
    public Prato cadastrar(Prato prato) {
        // ... lógica
        return pratoRepository.save(prato);
    }

    // CORREÇÃO: Removido 'static'
    public List<Prato> listar() {
        return pratoRepository.findAll();
    }

    // CORREÇÃO: Removido 'static'
    public Prato alterarDisponibilidade(Long id, boolean disponivel) {
        Object prato = null;
        // ... lógica
        return pratoRepository.saveAll(prato);
    }
}