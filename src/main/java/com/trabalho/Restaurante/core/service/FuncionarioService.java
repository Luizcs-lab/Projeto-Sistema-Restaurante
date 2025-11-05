package com.trabalho.Restaurante.core.service;

import com.trabalho.Restaurante.core.entity.Funcionario;
import com.trabalho.Restaurante.core.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 1. Anotação que registra esta classe como um bean de serviço
public class FuncionarioService {

    private static FuncionarioRepository funcionarioRepository;
        
            // 2. Injeção de dependência via construtor (prática recomendada)
            @Autowired
            public FuncionarioService(FuncionarioRepository funcionarioRepository) {
                FuncionarioService.funcionarioRepository = funcionarioRepository;
        }
    
        // --- MÉTODOS DE CRUD DEVEM SER INSERIDOS AQUI ---
    
        // 1. Método SALVAR
        public Funcionario salvar(Funcionario funcionario) {
            return funcionarioRepository.save(funcionario);
        }
    
        // 2. Método BUSCAR TODOS
        public static List<Funcionario> buscarTodos() {
            try {
                return funcionarioRepository.findAll();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                        return null;
        }
    
        // 3. Método BUSCAR POR ID
        public Optional<Funcionario> buscarPorId(Long id) {
            return funcionarioRepository.findById(id);
        }
    
        // 4. Método DELETAR POR ID
        public static void deletarPorId(Long id) {
            funcionarioRepository.deleteById(id);
    }
    
    // (Opcional) 5. Método BUSCAR POR EMAIL (se definido no Repository)
    public Optional<Funcionario> buscarPorEmail(String email) {
        return funcionarioRepository.findByEmail(email);
    }

    public Funcionario cadastrar(Funcionario funcionario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    public Funcionario autenticar(String email, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autenticar'");
    }
}