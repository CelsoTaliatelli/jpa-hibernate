package DAO;


import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class Repository<T> {

    protected EntityManager em;
    final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
    Class<T> entidade = (Class<T>) (type).getActualTypeArguments()[0];
    /**
     *
     * @param em EntityManager
     * */
    public Repository(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(T entidade) {
        em.persist(entidade);
    }

    public T buscarPorId(Long id) {
        return (T) em.find(entidade,id);
    }

    public List<T> buscarTodos() {
        var entidade = this.entidade.getName();
        var jpql = "SELECT m FROM " + entidade + " m";
        return em.createQuery(jpql).getResultList();
    }

    public void remove(T entidade){
        entidade = em.merge(entidade);
        em.remove(entidade);
    }

}
