package com.trabalho.Restaurante.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.Restaurante.core.entity.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long> {
    static Optional<Prato> findByNome(String nome) {
        // 
        throw new UnsupportedOperationException("Unimplemented method 'findByNome'");
    }

    Prato saveAll(Object prato);


   
}
