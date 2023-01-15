package DAO;

import modelo.Pedido;
import modelo.Produto;

import javax.persistence.EntityManager;

public class PedidoDAO extends Repository<Pedido>{


    public PedidoDAO(EntityManager em) {
        super(em);
    }
}
