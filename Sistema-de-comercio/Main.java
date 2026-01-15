import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1L, "Maria", "maria@email.com", "123.456.789-00", "8888-8888");

        Produto produto = new Produto(10L, "Mouse", "Mouse sem fio", 80.0, 20);
        ItemPedido item = new ItemPedido(100L, 2, 80.0, produto);

        Pedido pedido = new Pedido(200L, new Date(), "ABERTO");
        pedido.adicionarItem(item);
        cliente.fazerPedido(pedido);

        Pagamento pagamento = new PagamentoPix(300L, pedido.getValorTotal(), new Date(), "PENDENTE", "chave@pix", "TX123");
        pedido.setPagamento(pagamento);
        pagamento.processar();

        System.out.println("Pedidos do cliente: " + cliente.consultarPedidos().size());
        System.out.println("Total do pedido: " + pedido.getValorTotal());
        System.out.println("Status do pagamento: " + pagamento.getStatus());
    }
}
