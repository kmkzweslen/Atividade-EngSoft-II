import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Long id;
    private Date dataPedido;
    private String status;
    private Double valorTotal;

    private Cliente cliente;
    private Pagamento pagamento;
    private final List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Long id, Date dataPedido, String status) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.status = status;
        this.valorTotal = 0.0;
    }

    public void adicionarItem(ItemPedido item) {
        if (item == null) {
            return;
        }
        if (!itens.contains(item)) {
            itens.add(item);
        }
        item.setPedido(this);
        calcularTotal();
    }

    public void removerItem(ItemPedido item) {
        if (item == null) {
            return;
        }
        itens.remove(item);
        calcularTotal();
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        this.valorTotal = total;
        return total;
    }

    public void finalizarPedido() {
        this.status = "FINALIZADO";
        calcularTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        if (cliente != null) {
            cliente.fazerPedido(this);
        }
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }
}
