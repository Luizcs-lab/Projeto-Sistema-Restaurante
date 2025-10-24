package com.trabalho.Restaurante.core.service;

import com.trabalho.Restaurante.core.entity.Funcionario;
import com.trabalho.Restaurante.core.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario autenticar(String email, String senha) throws Exception {
        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);

        if (funcionario.isEmpty()) {
            throw new Exception("Funcionário não encontrado");
        }

        Funcionario f = funcionario.get();

        if (!f.isAtivo()) {
            throw new Exception("Funcionário inativo");
        }

        if (!f.getSenha().equals(senha)) {
            throw new Exception("Senha incorreta");
        }

        return f; // sucesso!
    }

    public Funcionario cadastrar(Funcionario funcionario) throws Exception {
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new Exception("Email já cadastrado");
        }

        return funcionarioRepository.save(funcionario);
    }
}
