package com.trabalho.crud.core.service;

import com.trabalho.Restaurante.core.entity.Funcionario;
import com.trabalho.Restaurante.core.repository.FuncionarioRepository;
import com.trabalho.Restaurante.core.service.FuncionarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyLong; // Importação essencial para Long/long
import static org.mockito.ArgumentMatchers.any; 
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    private Funcionario funcionarioMock;

    @BeforeEach
    void setUp() {
        funcionarioMock = new Funcionario();
        funcionarioMock.setId(1L);
        funcionarioMock.setName("João Silva");
        funcionarioMock.setEmail("joao@email.com");
    }

    // --- Teste de Criar/Salvar ---
    @Test
    void deveSalvarFuncionarioComSucesso() {
        // Usa any(Funcionario.class) para garantir a segurança de tipo
        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionarioMock);

        Funcionario funcionarioSalvo = funcionarioService.salvar(funcionarioMock);

        assertNotNull(funcionarioSalvo, "O funcionário não deve ser nulo.");
        assertEquals(funcionarioMock.getName(), funcionarioSalvo.getName(), "O nome deve ser o mesmo.");
        verify(funcionarioRepository, times(1)).save(any(Funcionario.class));
    }

    // --- Teste de Buscar Todos ---
    @Test
    void deveRetornarTodosFuncionarios() {
        List<Funcionario> listaEsperada = Arrays.asList(funcionarioMock, new Funcionario());
        when(funcionarioRepository.findAll()).thenReturn(listaEsperada);

        List<Funcionario> resultado = FuncionarioService.buscarTodos();

        assertNotNull(resultado, "A lista não deve ser nula.");
        assertEquals(2, resultado.size(), "A lista deve conter 2 funcionários.");
        verify(funcionarioRepository, times(1)).findAll();
    }
    
    // --- Teste de Buscar por ID Existente ---
    @Test
    void deveRetornarFuncionarioPorIdExistente() {
        // Usa eq(1L) para testar um ID específico
        when(funcionarioRepository.findById(eq(1L))).thenReturn(Optional.of(funcionarioMock));
        
        Optional<Funcionario> resultado = funcionarioService.buscarPorId(1L);
        
        assertTrue(resultado.isPresent(), "Deve encontrar o funcionário.");
        assertEquals("João Silva", resultado.get().getName());
        verify(funcionarioRepository, times(1)).findById(eq(1L));
    }
    
    // --- Teste de Buscar por ID Inexistente ---
    @Test
void deveRetornarVazioParaIdInexistente() {
    // MUDANÇA: Usar any(Long.class)
    when(funcionarioRepository.findById(any(Long.class))).thenReturn(Optional.empty());
    
    // ... ACT
    Optional<Funcionario> resultado = funcionarioService.buscarPorId(99L);
    
    // ... ASSERT
    assertFalse(resultado.isPresent(), "Não deve encontrar o funcionário.");
    
    // MUDANÇA: Usar any(Long.class)
    verify(funcionarioRepository, times(1)).findById(any(Long.class));
}

    // --- Exemplo de teste para o método deletar ---
    @Test
    void deveDeletarFuncionarioComSucesso() {
        // ARRANGE
        // MUDANÇA: Usar any(Long.class) em vez de anyLong()
        doNothing().when(funcionarioRepository).deleteById(any(Long.class)); 
        
        // ACT
        FuncionarioService.deletarPorId(1L);
        
        // ASSERT/VERIFY
        // MUDANÇA: Usar any(Long.class) em vez de anyLong()
        verify(funcionarioRepository, times(1)).deleteById(any(Long.class)); 
    }
}