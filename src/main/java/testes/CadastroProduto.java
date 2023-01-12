package testes;

import DAO.ProdutoDAO;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Iphone 11");
        celular.setDescricao("Celular da Apple");
        celular.setPreco(new BigDecimal("12000"));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO dao = new ProdutoDAO(em);
        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
