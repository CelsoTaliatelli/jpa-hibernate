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
    @Column(name = "valor_total")
    private BigDecimal valortotal;
    private LocalDate dataPedido = LocalDate.now();
    @ManyToOne
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

        itensPedido.stream().forEach(p -> {
            this.valortotal.add(p.getPrecoUnitario().multiply(BigDecimal.valueOf(p.getQuantidade())));
        });

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
