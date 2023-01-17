package modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {



    @EmbeddedId
    private CategoriaID categoriaID;

    public String getNome() {
        return this.categoriaID.getNome();
    }

    public Categoria(String nome, String tipo) {
        this.categoriaID = new CategoriaID(nome, tipo);
    }
    public Categoria(){}
}
