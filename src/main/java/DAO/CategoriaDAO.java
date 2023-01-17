package DAO;

import modelo.Categoria;
import modelo.CategoriaID;

import javax.persistence.EntityManager;

public class CategoriaDAO extends CrudRepository<Categoria, CategoriaID> {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        super(em);
    }
}
