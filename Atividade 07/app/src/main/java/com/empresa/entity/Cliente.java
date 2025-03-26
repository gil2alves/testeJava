package com.empresa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    private Long id;

    private String nome;

    private String cidade;

    @Column(name = "tipo_industria")
    private String tipoIndustria;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
    
    public Cliente() {}

    public Cliente(Long id, String nome, String cidade, String tipoIndustria) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.tipoIndustria = tipoIndustria;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoIndustria() {
        return tipoIndustria;
    }

    public void setTipoIndustria(String tipoIndustria) {
        this.tipoIndustria = tipoIndustria;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
