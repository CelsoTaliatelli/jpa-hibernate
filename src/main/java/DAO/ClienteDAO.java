package DAO;

import modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteDAO extends Repository<Cliente>{
    private EntityManager em;

    public ClienteDAO(EntityManager em){
        super(em);
    }
}
