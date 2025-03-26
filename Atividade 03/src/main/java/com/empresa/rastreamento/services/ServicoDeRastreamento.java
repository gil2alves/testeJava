package com.empresa.rastreamento.services;

import com.empresa.rastreamento.interfaces.RastreioProduto;

public class ServicoDeRastreamento {

    private final RastreioProduto rastreador;

    public ServicoDeRastreamento(RastreioProduto rastreador) {
        this.rastreador = rastreador;
    }

    public void verificarStatusProduto(String codigoProduto) {
        rastreador.rastrear(codigoProduto);
    }
}