import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    private final List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Long id, String nome, String email, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public void fazerPedido(Pedido pedido) {
        if (pedido == null) {
            return;
        }
        if (!pedidos.contains(pedido)) {
            pedidos.add(pedido);
        }
        if (pedido.getCliente() != this) {
            pedido.setCliente(this);
        }
    }

    public List<Pedido> consultarPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
