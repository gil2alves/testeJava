package com.empresa.service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import com.empresa.repository.VendedorRepository;

@ApplicationScoped
@Path("vendedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendedorService {

    @Inject
    private VendedorRepository vendedorRepository;

    @GET
    @Path("/semPedidos/{cliente}")
    public List<String> vendedoresSemPedidos(@PathParam("cliente") String cliente) {
        return vendedorRepository.vendedoresSemPedidosComCliente(cliente);
    }

    @PUT
    @Path("/adicionarAsterisco")
    public void adicionarAsterisco() {
        vendedorRepository.adicionarAsteriscoEmVendedoresComMaisDeDoisPedidos();
    }

    @DELETE
    @Path("/excluirPorCidade/{cidade}")
    public void excluirPorCidade(@PathParam("cidade") String cidade) {
        vendedorRepository.excluirVendedoresComPedidosNaCidade(cidade);
    }

    @GET
    @Path("/totalVendas")
    public List<Object[]> totalVendas() {
        return vendedorRepository.totalVendasPorVendedor();
    }
    @GET
    @Path("/teste")
    @Produces(MediaType.TEXT_PLAIN)
    public String teste() {
        return "Funcionando!";
    }

}
