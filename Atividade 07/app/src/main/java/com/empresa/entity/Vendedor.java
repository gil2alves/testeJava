package com.empresa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Vendedor {

    @Id
    private Long id;

    private String nome;

    private int idade;

    private double salario;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Vendedor() {}

    public Vendedor(long id, String nome, int idade, double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

	// Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
