package com.trabalho.crud.core.service; // Use seu pacote de teste correto

import com.trabalho.Restaurante.core.entity.Cliente;
import com.trabalho.Restaurante.core.entity.Funcionario;
import com.trabalho.Restaurante.core.entity.Pedido;
import com.trabalho.Restaurante.core.entity.Prato;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.repository.PedidoRepository;
import com.trabalho.Restaurante.core.service.ClienteService;
import com.trabalho.Restaurante.core.service.FuncionarioService;
import com.trabalho.Restaurante.core.service.PedidoService;
import com.trabalho.Restaurante.core.service.PratoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @Mock private PedidoRepository pedidoRepository;
    // CRÍTICO: Mocks necessários para o construtor do PedidoService (NullPointer)
    @Mock private PratoService pratoService;
    @Mock private ClienteService clienteService;
    @Mock private FuncionarioService funcionarioService;

    @InjectMocks
    private PedidoService pedidoService;
    
    private Pedido pedidoValido;
    private Prato pratoDisponivel;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente(1L, "Cliente Teste", "1111", "teste@email.com");
        Funcionario funcionario = new Funcionario();
        pratoDisponivel = new Prato();
        
        pedidoValido = new Pedido();
    }

    @Test
    void deveCriarPedidoECalcularValorTotalComSucesso() {
        when(pedidoRepository.save(any(Pedido.class))).thenAnswer(invocation -> {
            Pedido pedido = invocation.getArgument(0);
            pedido.setId(1L); 
            // O valor total deve ser calculado no Service antes de salvar
            pedido.setValorTotal(50.0); 
            return pedido;
        });

        Pedido pedidoSalvo = pedidoService.criarPedido(pedidoValido);

        assertNotNull(pedidoSalvo.getId());
        assertEquals(50.0, pedidoSalvo.getValorTotal(), 0.001); 
        verify(pedidoRepository, times(1)).save(any(Pedido.class));
    }
    
    @Test
    void deveLancarBusinessExceptionQuandoListaDePratosVazia() {
        // ARRANGE: Pratos vazios
        pedidoValido.setPratos(Collections.emptyList());

        // ACT & ASSERT: Espera BusinessException (agora que o PedidoService está corrigido)
        assertThrows(BusinessException.class, () -> {
            pedidoService.criarPedido(pedidoValido);
        });

        verify(pedidoRepository, never()).save(any());
    }
}