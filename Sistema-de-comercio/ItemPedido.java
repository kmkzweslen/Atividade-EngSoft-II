public class ItemPedido {
    private Long id;
    private Integer quantidade;
    private Double precoUnitario;
    private Double subtotal;

    private Produto produto;
    private Pedido pedido;

    public ItemPedido(Long id, Integer quantidade, Double precoUnitario, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.produto = produto;
        this.subtotal = 0.0;
    }

    public double calcularSubtotal() {
        double precoBase = precoUnitario != null ? precoUnitario : 0.0;
        if (produto != null && produto.getPreco() != null) {
            precoBase = produto.getPreco();
        }
        int qtd = quantidade != null ? quantidade : 0;
        this.subtotal = precoBase * qtd;
        return subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
