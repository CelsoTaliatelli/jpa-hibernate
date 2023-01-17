package testes;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import modelo.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {

    public static void main(String[] args) {
        em.getTransaction().begin();
        cadastrarProdutos();

        Cliente cliente = new Cliente("Celso","123456");
        ClienteDAO clienteDAO = new ClienteDAO(em);
        clienteDAO.cadastrar(cliente);

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        Produto produto = produtoDAO.buscarPorId(1L);

        Pedido pedido = new Pedido(cliente);
        pedido.addItem(new ItemPedido(5,pedido,produto));
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        pedidoDAO.cadastrar(pedido);

        em.getTransaction().commit();


        var relatorio = pedidoDAO.buscarPorId(1l).getItensPedido().get(0).getProduto().getNome();
        System.out.println(relatorio);

        closeEntityManger();
    }

    private static EntityManager em = JPAUtil.getEntityManager();

    private static void cadastrarProdutos() {
        Categoria categoria = new Categoria("CELULARES","XPTO");
        Produto celular = new Produto("Iphone 11","Celular",new BigDecimal("12000"), categoria);

        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        categoriaDAO.cadastrar(categoria);
        produtoDAO.cadastrar(celular);
    }

    private static void closeEntityManger(){
        em.close();
    }
}
