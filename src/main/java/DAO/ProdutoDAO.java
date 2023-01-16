package DAO;

import modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO extends Repository<Produto>{
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        super(em);
    }

    public List<Produto> buscarPorNome(String nome) {
        var jpql = "SELECT p FROM Produto p where p.nome.categoria.nome = :nome";
        return em.createQuery(jpql)
                .setParameter("nome",nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nome) {
        return em.createNamedQuery("Produto.produtosPorCategoria",Produto.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public BigDecimal buscarItemPorPreco(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

}
