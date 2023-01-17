package DAO;

import modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO extends CrudRepository<Produto, Long> {
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
    public Produto buscaPorParametroComCriteria(String nome, BigDecimal preco) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> produtoCriteriaQuery = builder.createQuery(Produto.class);
        Root<Produto> from = produtoCriteriaQuery.from(Produto.class);
        Predicate filtros = builder.and();
        if(nome != null && !nome.trim().isEmpty()) {
            filtros = builder.and(filtros,builder.equal(from.get("nome"),nome));
        }
        if(preco != null) {
            filtros = builder.and(filtros,builder.equal(from.get("preco"),preco));
        }
        produtoCriteriaQuery.where(filtros);

        return em.createQuery(produtoCriteriaQuery).getSingleResult();

    }

}
