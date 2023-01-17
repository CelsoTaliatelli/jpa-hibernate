package DAO;

import modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteDAO extends CrudRepository<Cliente, Long> {
    private EntityManager em;

    public ClienteDAO(EntityManager em){
        super(em);
    }
}
