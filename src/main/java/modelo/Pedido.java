package modelo;

import org.hibernate.annotations.Fetch;

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
    @Column(name = "valor_total")
    private BigDecimal valorTotal = new BigDecimal("0");
    @Column(name = "data_pedido")
    private LocalDate dataPedido = LocalDate.now();
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido = new ArrayList<>();

    public Pedido(Cliente cliente){
        this.cliente = cliente;
    }

    public Pedido(){}

    public Long getId() {
        return id;
    }

    public BigDecimal getValortotal() {
        return valorTotal;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void addItem(ItemPedido item) {
        item.setPedido(this);
        this.itensPedido.add(item);
        this.valorTotal = item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade()));
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
