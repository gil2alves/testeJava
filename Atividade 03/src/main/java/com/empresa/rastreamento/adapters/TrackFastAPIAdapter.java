package com.empresa.rastreamento.adapters;

import com.empresa.rastreamento.interfaces.RastreioProduto;

public class TrackFastAPIAdapter implements RastreioProduto {

    @Override
    public void rastrear(String codigoProduto) {
        System.out.println("Rastreando produto [TrackFastAPI]: " + codigoProduto);
        System.out.println("Status: Em trânsito");
    }
}