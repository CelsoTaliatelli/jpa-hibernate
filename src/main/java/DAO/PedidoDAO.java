package DAO;

import modelo.Pedido;
import modelo.Produto;
import modelo.RelatorioDeVendasVO;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO extends Repository<Pedido>{


    public PedidoDAO(EntityManager em) {
        super(em);
    }
    public BigDecimal valorTotalVendido() {
        var entidade = this.entidade.getName();
        var jpql = "SELECT SUM(p.valorTotal) FROM " + entidade + " p";
        return em.createQuery(jpql,BigDecimal.class)
                .getSingleResult();
    }

    @Deprecated
    /**
     * @apiNote método depreciado utiltize o metodo relatorioDeVendasV2
     */
    public List<Object[]> relatorioDeVendas() {
        String jpql = "SELECT produto.nome, " +
                "SUM(item.quantidade), " +
                "MAX(pedido.dataPedido) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itensPedido item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY item.quantidade DESC";
        return em.createQuery(jpql,Object[].class)
        .getResultList();
    }
    public List<RelatorioDeVendasVO> relatorioDeVendasV2() {
        String jpql = "SELECT new modelo.RelatorioDeVendasVO( " +
                "produto.nome, " +
                "SUM(item.quantidade), " +
                "MAX(pedido.dataPedido)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itensPedido item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY item.quantidade DESC";
        return em.createQuery(jpql,RelatorioDeVendasVO.class)
                .getResultList();
    }


}
