package com.trabalho.Restaurante.core.repository;

import com.trabalho.Restaurante.core.entity.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PratoRepository extends JpaRepository<Prato, Long> {
    Optional<Prato> findByNome(String nome);
}
