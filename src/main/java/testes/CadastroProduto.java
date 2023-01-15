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
import java.util.List;

public class CadastroProduto {
    public static void main(String[] args) {
        cadastrarProdutos();
        buscarProduto(1L);
        buscarTodosProdutos();
        closeEntityManger();
    }

    private static EntityManager em = JPAUtil.getEntityManager();

    private static void cadastrarProdutos() {
        Categoria categoria = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone 11","Celular",new BigDecimal("12000"), categoria);

        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        em.getTransaction().begin();
        categoriaDAO.cadastrar(categoria);
        produtoDAO.cadastrar(celular);
        em.getTransaction().commit();
    }

    private static void buscarProduto(Long id){
        ProdutoDAO produtoDao = new ProdutoDAO(em);
        Produto produto = produtoDao.buscarPorId(id);
        System.out.println(produto.getPreco());

    }

    private static void buscarTodosProdutos() {
        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        List<Produto> produtos = produtoDAO.buscarTodos();
        produtos.forEach(p -> {
            System.out.println(p.getNome());
        });
    }

    private static void closeEntityManger(){
        em.close();
    }
}
