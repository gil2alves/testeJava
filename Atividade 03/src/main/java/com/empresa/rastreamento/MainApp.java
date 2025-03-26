package com.empresa.rastreamento;

import com.empresa.rastreamento.adapters.TrackFastAPIAdapter;
import com.empresa.rastreamento.adapters.QuickTrackServiceAdapter;
import com.empresa.rastreamento.interfaces.RastreioProduto;
import com.empresa.rastreamento.services.ServicoDeRastreamento;

public class MainApp {
    public static void main(String[] args) {
        
        RastreioProduto rastreador = new TrackFastAPIAdapter();
        ServicoDeRastreamento servico = new ServicoDeRastreamento(rastreador);
        servico.verificarStatusProduto("PROD123");

        
        rastreador = new QuickTrackServiceAdapter();
        servico = new ServicoDeRastreamento(rastreador);
        servico.verificarStatusProduto("PROD456");
    }
}