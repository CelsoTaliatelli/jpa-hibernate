package testes;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone 11","Celular",new BigDecimal("12000"), categoria);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        em.getTransaction().begin();
        categoriaDAO.cadastrar(categoria);
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
