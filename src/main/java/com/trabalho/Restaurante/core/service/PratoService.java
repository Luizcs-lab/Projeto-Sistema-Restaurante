package com.trabalho.Restaurante.core.service;

import com.trabalho.Restaurante.core.entity.Prato;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.repository.PratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {

    private final PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public Prato cadastrar(Prato prato) {
        if (prato.getNome() == null || prato.getNome().isBlank()) {
            throw new BusinessException("O nome do prato é obrigatório");
        }

        if (prato.getPreco() <= 0) {
            throw new BusinessException("O preço do prato deve ser maior que zero");
        }

        if (prato.getCategoria() == null || prato.getCategoria().isBlank()) {
            throw new BusinessException("A categoria do prato é obrigatória");
        }

        if (pratoRepository.findByNome(prato.getNome()).isPresent()) {
            throw new BusinessException("Já existe um prato com esse nome");
        }

        return pratoRepository.save(prato);
    }

    public List<Prato> listar() {
        return pratoRepository.findAll();
    }

    public Prato alterarDisponibilidade(Long id, boolean disponivel) {
        Prato prato = pratoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Prato não encontrado"));
        prato.setDisponivel(disponivel);
        return pratoRepository.save(prato);
    }
}
