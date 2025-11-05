package com.trabalho.Restaurante.core.service;

import com.trabalho.Restaurante.core.entity.Cliente;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private static ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        ClienteService.clienteRepository = clienteRepository;
    }

    // CORREÇÃO: Removido 'static'
    public static Cliente cadastrar(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new BusinessException("O nome do cliente é obrigatório");
        }

        if (clienteRepository.findByTelefone(cliente.getTelefone()).isPresent()) {
            throw new BusinessException("Telefone já cadastrado");
        }

        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new BusinessException("Email já cadastrado");
        }

        return clienteRepository.save(cliente);
    }

    // CORREÇÃO: Removido 'static'
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // CORREÇÃO: Removido 'static'
    public static void excluir(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new BusinessException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

    // CORREÇÃO: Removido 'static'
    public Cliente buscarPorId(Long id) {
        // O findById retorna um Optional, que deve ser tratado.
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente com ID " + id + " não encontrado."));
    }
}