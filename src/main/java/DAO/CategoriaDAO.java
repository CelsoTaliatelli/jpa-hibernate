package DAO;

import modelo.Categoria;
import modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDAO extends Repository<Categoria>{
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        super(em);
    }
}
