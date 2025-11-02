package main.java.com.trabalho.Restaurante.core.service;

import com.trabalho.Restaurante.core.entity.*;
import com.trabalho.Restaurante.core.exception.BusinessException;
import com.trabalho.Restaurante.core.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PratoService pratoService;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;

    public PedidoService(PedidoRepository pedidoRepository, PratoService pratoService,
                         ClienteService clienteService, FuncionarioService funcionarioService) {
        this.pedidoRepository = pedidoRepository;
        this.pratoService = pratoService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    public Pedido criarPedido(Pedido pedido) {
        if (pedido.getCliente() == null) {
            throw new BusinessException("O pedido precisa ter um cliente");
        }

        if (pedido.getFuncionario() == null) {
            throw new BusinessException("O pedido precisa ter um funcionário responsável");
        }

        if (pedido.getPratos() == null || pedido.getPratos().isEmpty()) {
            throw new BusinessException("O pedido deve conter ao menos um prato");
        }

        // Verifica se todos os pratos estão disponíveis
        for (Prato prato : pedido.getPratos()) {
            if (!prato.isDisponivel()) {
                throw new BusinessException("O prato '" + prato.getNome() + "' não está disponível");
            }
        }

        // Calcula o valor total
        double total = pedido.getPratos().stream()
                .mapToDouble(Prato::getPreco)
                .sum();

        pedido.setValorTotal(total);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
 
    

