package modelo;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CategoriaID implements Serializable {
    private String  nome;
    private String tipo;

    public CategoriaID(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public CategoriaID() {
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}
