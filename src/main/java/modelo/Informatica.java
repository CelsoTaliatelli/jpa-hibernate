package modelo;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Informatica extends Produto{
    private String marca;
    private Integer modelo;

    public Informatica(String nome, String descricao, BigDecimal preco, Categoria categoria, String marca, Integer modelo) {
        super(nome, descricao, preco, categoria);
        this.marca = marca;
        this.modelo = modelo;
    }

    public Informatica(String marca, Integer modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Informatica () {}

    public String getMarca() {
        return marca;
    }

    public Integer getModelo() {
        return modelo;
    }
}
