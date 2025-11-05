package com.trabalho.Restaurante.core.service;

import com.trabalho.Restaurante.core.entity.Pedido;
import com.trabalho.Restaurante.core.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import com.trabalho.Restaurante.core.exception.BusinessException;
import java.util.List;

@Service
public class PedidoService {

    private static PedidoRepository pedidoRepository = null;
    private final PratoService pratoService;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;

    // CRÍTICO: Este deve ser o ÚNICO construtor para garantir a injeção do Mockito
    public PedidoService(
        PedidoRepository pedidoRepository,
        PratoService pratoService,
        ClienteService clienteService,
        FuncionarioService funcionarioService) {
        
        PedidoService.pedidoRepository = pedidoRepository;
        this.pratoService = pratoService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }
    
    public static Pedido criarPedido(Pedido pedido) {
        // Correção de lógica de teste (BusinessException quando lista vazia)
        if (pedido.getPratos() == null || pedido.getPratos().isEmpty()) {
             throw new BusinessException("O pedido deve conter ao menos um prato");
        }
        
        // ... Lógica de cálculo de valor total ...
        
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPedidos'");
    }
    
    // ... outros métodos ...
    
    // NÃO deve existir aqui: public Pedido alterarDisponibilidade(...)
}