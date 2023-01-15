package modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  nome;

    public String getNome() {
        return nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
    public Categoria(){}
}
