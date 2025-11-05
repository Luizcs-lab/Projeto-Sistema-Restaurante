package com.trabalho.crud.core.service;

import com.trabalho.Restaurante.core.entity.Cliente;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.repository.ClienteRepository;
import com.trabalho.Restaurante.core.service.ClienteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// CRÍTICO: Garantir a inicialização do Mockito
@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private final Long ID_CLIENTE = 1L;

    @BeforeEach
    void setUp() {
        new Cliente(ID_CLIENTE, "João da Silva", "999999999", "joao@teste.com");
    }
    
    // ... teste de cadastrar() com sucesso

    @Test
    void deveExcluirClienteComSucesso() {
        // ARRANGE: Simula que o cliente existe
        when(clienteRepository.existsById(ID_CLIENTE)).thenReturn(true);

        // ACT
        ClienteService.excluir(ID_CLIENTE);

        // ASSERT: Verifica se o método de exclusão foi chamado
        verify(clienteRepository, times(1)).existsById(ID_CLIENTE);
        verify(clienteRepository, times(1)).deleteById(ID_CLIENTE);
    }
    
    @Test
    void deveLancarBusinessExceptionAoExcluirClienteInexistente() {
        // ARRANGE: Simula que o cliente NÃO existe
        when(clienteRepository.existsById(ID_CLIENTE)).thenReturn(false);

        // ACT & ASSERT
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            ClienteService.excluir(ID_CLIENTE);
        });

        assertEquals("Cliente não encontrado", exception.getMessage());
        // CRÍTICO: Verifica que a exclusão NÃO foi chamada
        verify(clienteRepository, never()).deleteById(any());
    }
}