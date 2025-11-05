// com.trabalho.Restaurante.core.repository/FuncionarioRepository.java

package com.trabalho.Restaurante.core.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trabalho.Restaurante.core.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Spring Data JPA cria a query automaticamente
    Optional<Funcionario> findByEmail(String email);
    
    // Todos os outros métodos (save, findAll, findById, deleteById)
    // são herdados de JpaRepository e não precisam ser declarados aqui.
}