package com.trabalho.crud.core.service; // Use seu pacote de teste correto

import com.trabalho.Restaurante.core.entity.Funcionario;
import com.trabalho.Restaurante.core.repository.FuncionarioRepository;
import com.trabalho.Restaurante.core.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    private Funcionario funcionarioAtivo;
    private Funcionario funcionarioInativo;
    private final String SENHA_CORRETA = "senha123";

    @BeforeEach
    void setUp() {
        funcionarioAtivo = new Funcionario();
        funcionarioInativo = new Funcionario();
    }

    @Test
    void deveAutenticarFuncionarioComSucesso() throws Exception {
        when(funcionarioRepository.findByEmail(funcionarioAtivo.getEmail()))
            .thenReturn(Optional.of(funcionarioAtivo));

        Funcionario fAutenticado = funcionarioService.autenticar(funcionarioAtivo.getEmail(), SENHA_CORRETA);

        // CORRIGIDO: Verifica se o resultado NÃO é nulo e se o email está correto.
        assertNotNull(fAutenticado); 
        assertEquals("alice@rest.com", fAutenticado.getEmail());
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioInativo() {
        when(funcionarioRepository.findByEmail(funcionarioInativo.getEmail()))
            .thenReturn(Optional.of(funcionarioInativo));

        // Agora, com a correção em Funcionario.java, a exceção correta será lançada.
        Exception exception = assertThrows(Exception.class, () -> {
            funcionarioService.autenticar(funcionarioInativo.getEmail(), SENHA_CORRETA);
        });

        assertEquals("Funcionário inativo", exception.getMessage());
    }
}