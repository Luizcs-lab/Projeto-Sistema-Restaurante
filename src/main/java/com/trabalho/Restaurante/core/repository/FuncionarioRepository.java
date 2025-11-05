package com.trabalho.Restaurante.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trabalho.Restaurante.core.entity.Funcionario;



// Supondo que o ID (chave primária) de Funcionario seja do tipo Long
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

   // O Spring Data JPA cria a implementação deste método automaticamente
    Optional<Funcionario> findByEmail(String email);

    
}
