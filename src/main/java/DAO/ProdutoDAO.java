package DAO;

import modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class,id);
    }

    public List<Produto> buscarTodos() {
        var jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        var jpql = "SELECT p FROM Produto p where p.nome.categoria.nome = :nome";
        return em.createQuery(jpql)
                .setParameter("nome",nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nome) {
        var jpql = "SELECT p FROM Produto p where p.nome = :nome";
        return em.createQuery(jpql)
                .setParameter("nome",nome)
                .getResultList();
    }
}
