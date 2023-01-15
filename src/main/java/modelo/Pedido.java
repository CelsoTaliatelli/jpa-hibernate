package modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valortotal;
    private LocalDate dataPedido = LocalDate.now();
    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public Pedido(Cliente cliente, BigDecimal valorTotal){
        this.cliente = cliente;
        this.valortotal = valorTotal;
    }

    public Pedido(){}

    public Long getId() {
        return id;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void addItem(ItemPedido item) {
        item.setPedido(this);
        this.itensPedido.add(item);
    }

    public Cliente getCliente() {
        return cliente;
    }
}
