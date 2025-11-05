package com.trabalho.Restaurante.core.entity;

import jakarta.persistence.*; // Use 'jakarta' se for Spring Boot 3+

// Assumindo que você usa Lombok para getters/setters
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    
    // Campo booleano para o status
    private boolean ativo; 

    // Construtores, Getters e Setters (Se não usar Lombok)
    
    // Se você não usa Lombok e implementou o getter manualmente
    // e ele estava com erro, use este corpo:
    public boolean isAtivo() {
        return this.ativo;
    }

	public Object getSenha() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getSenha'");
	}

    public String getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    public Object getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void setId(long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
    
    // Se você usa Lombok, garanta que não existe um isAtivo manual e errado.
    // Basta garantir que o campo 'ativo' existe.
}