package com.empresa.repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class VendedorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<String> vendedoresSemPedidosComCliente(String nomeCliente) {
        String jpql = "SELECT v.nome FROM Vendedor v WHERE v.id NOT IN (" +
                      "SELECT o.vendedor.id FROM Pedido o " +
                      "JOIN o.cliente c " +
                      "WHERE c.nome = :nomeCliente)";
        return entityManager.createQuery(jpql, String.class)
                             .setParameter("nomeCliente", nomeCliente)
                             .getResultList();
    }

    public void adicionarAsteriscoEmVendedoresComMaisDeDoisPedidos() {
        String jpql = "UPDATE Vendedor v SET v.nome = CONCAT(v.nome, '*') " +
                      "WHERE v.id IN (" +
                      "SELECT o.vendedor.id FROM Pedido o GROUP BY o.vendedor.id HAVING COUNT(o.id) >= 2)";
        entityManager.createQuery(jpql).executeUpdate();
    }

    public void excluirVendedoresComPedidosNaCidade(String cidade) {
        String jpql = "DELETE FROM Vendedor v WHERE v.id IN (" +
                      "SELECT o.vendedor.id FROM Pedido o " +
                      "JOIN o.cliente c " +
                      "WHERE c.cidade = :cidade)";
        entityManager.createQuery(jpql)
                     .setParameter("cidade", cidade)
                     .executeUpdate();
    }

    public List<Object[]> totalVendasPorVendedor() {
        String jpql = "SELECT v.nome, COALESCE(SUM(o.valor), 0) FROM Vendedor v " +
                      "LEFT JOIN Pedido o ON v.id = o.vendedor.id " +
                      "GROUP BY v.nome";
        return entityManager.createQuery(jpql, Object[].class).getResultList();
    }
}
