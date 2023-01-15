package DAO;

import modelo.Categoria;
import modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void atualizar(Categoria categoria){
        this.em.merge(categoria); //se entidadeestiver detached volta para managed
    }

    public void remover(Categoria categoria) {
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }
}