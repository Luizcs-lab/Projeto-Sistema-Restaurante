package com.trabalho.crud.core.service; // Use seu pacote de teste correto

import com.trabalho.Restaurante.core.entity.Prato;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.repository.PratoRepository;
import com.trabalho.Restaurante.core.service.PratoService;
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
public class PratoServiceTest {

    @Mock
    private PratoRepository pratoRepository;

    @InjectMocks
    private PratoService pratoService;

    private Prato pratoValido;
    private final Long ID_PRATO = 1L;

    @BeforeEach
    void setUp() {
        pratoValido = new Prato();
    }

    @Test
    void deveCadastrarPratoComSucesso() {
        // CORRIGIDO: Simulação do findByNome para evitar UnsupportedOperationException
        when(PratoRepository.findByNome(pratoValido.getNome())).thenReturn(Optional.empty()); 
        when(pratoRepository.save(any(Prato.class))).thenReturn(pratoValido);

        Prato pratoSalvo = pratoService.cadastrar(pratoValido);

        assertNotNull(pratoSalvo);
        verify(pratoRepository, times(1)).save(pratoValido);
    }

    @Test
    void deveAlterarDisponibilidadeDoPratoComSucesso() {
        Prato pratoAlterado = new Prato();

        when(pratoRepository.findById(ID_PRATO)).thenReturn(Optional.of(pratoValido));
        when(pratoRepository.save(any(Prato.class))).thenReturn(pratoAlterado);

        // Chamada correta (PratoService, não PedidoService)
        Prato resultado = pratoService.alterarDisponibilidade(ID_PRATO, false);

        assertFalse(resultado.isDisponivel());
        verify(pratoRepository, times(1)).save(any(Prato.class));
    }
}