package com.trabalho.Restaurante.core.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToMany
    private List<Prato> pratos;

    private double valorTotal;

    private LocalDateTime dataHora = LocalDateTime.now();

    public Pedido() {}

    // Getters e Setters
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
    public List<Prato> getPratos() { return pratos; }
    public void setPratos(List<Prato> pratos) { this.pratos = pratos; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
    public LocalDateTime getDataHora() { return dataHora; }

    public void setId(long l) {
        // 
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
