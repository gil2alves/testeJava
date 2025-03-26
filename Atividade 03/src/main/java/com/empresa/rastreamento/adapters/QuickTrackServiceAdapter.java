package com.empresa.rastreamento.adapters;

import com.empresa.rastreamento.interfaces.RastreioProduto;

public class QuickTrackServiceAdapter implements RastreioProduto {

    @Override
    public void rastrear(String codigoProduto) {
        System.out.println("Rastreando produto [QuickTrackService]: " + codigoProduto);
        System.out.println("Status: Entregue");
    }
}