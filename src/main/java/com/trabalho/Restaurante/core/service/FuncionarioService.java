package com.trabalho.Restaurante.core.service;

import com.trabalho.Restaurante.core.entity.Funcionario;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
// Assumindo @RequiredArgsConstructor ou Construtor Manual
public class FuncionarioService {

    private static FuncionarioRepository funcionarioRepository = null;

    // Construtor para injeção de dependência (sem @Autowired no campo)
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        FuncionarioService.funcionarioRepository = funcionarioRepository;
    }

    // Método que estava usando 'isAtivo'
    public static Funcionario autenticar(String email, Object senha) throws Exception {
        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);

        if (funcionario.isEmpty()) {
            throw new Exception("Funcionário não encontrado");
        }
        
        Funcionario f = funcionario.get();

        // Agora este método funcionará após a correção em Funcionario.java
        if (!f.isAtivo()) {
            throw new Exception("Funcionário inativo");
        }

        if (!f.getSenha().equals(senha)) {
            throw new Exception("Senha incorreta");
        }

        return f; 
    }

    public Funcionario cadastrar(Funcionario funcionario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }
    
    // ... outros métodos ...
}