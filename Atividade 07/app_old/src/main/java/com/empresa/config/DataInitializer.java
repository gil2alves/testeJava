package com.empresa.config;

import com.empresa.entity.Cliente;
import com.empresa.entity.Pedido;
import com.empresa.entity.Vendedor;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;

@Singleton
@Startup
public class DataInitializer {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        // Inserir vendedores
        em.persist(new Vendedor(1L, "Abe", 61, 140000.0));
        em.persist(new Vendedor(2L, "Bob", 34, 44000.0));
        em.persist(new Vendedor(5L, "Chris", 34, 40000.0));
        em.persist(new Vendedor(7L, "Dan", 41, 52000.0));
        em.persist(new Vendedor(8L, "Ken", 57, 115000.0));
        em.persist(new Vendedor(11L, "Joe", 38, 38000.0));

        // Inserir clientes
        em.persist(new Cliente(4L, "Samsonic", "Pleasant", "J"));
        em.persist(new Cliente(6L, "Panasung", "Oaktown", "J"));
        em.persist(new Cliente(7L, "Samony", "Jackson", "B"));
        em.persist(new Cliente(9L, "Orange", "Jackson", "B"));

        // Inserir pedidos
        em.persist(new Pedido(10L, LocalDate.parse("1996-02-08"), em.find(Cliente.class, 4L), em.find(Vendedor.class, 2L), 540.0));
        em.persist(new Pedido(20L, LocalDate.parse("1999-01-30"), em.find(Cliente.class, 4L), em.find(Vendedor.class, 8L), 1800.0));
        em.persist(new Pedido(30L, LocalDate.parse("1995-07-14"), em.find(Cliente.class, 9L), em.find(Vendedor.class, 1L), 460.0));
        em.persist(new Pedido(40L, LocalDate.parse("1998-01-29"), em.find(Cliente.class, 7L), em.find(Vendedor.class, 2L), 2400.0));
        em.persist(new Pedido(50L, LocalDate.parse("1998-02-03"), em.find(Cliente.class, 6L), em.find(Vendedor.class, 7L), 600.0));
        em.persist(new Pedido(60L, LocalDate.parse("1998-03-02"), em.find(Cliente.class, 6L), em.find(Vendedor.class, 7L), 720.0));
        em.persist(new Pedido(70L, LocalDate.parse("1998-05-06"), em.find(Cliente.class, 9L), em.find(Vendedor.class, 7L), 150.0));
    }
}
