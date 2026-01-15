import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String matricula;
    private String email;
    private String telefone;
    private String tipo;

    private final List<Reserva> reservas = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(Long id, String nome, String matricula, String email, String telefone, String tipo) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void fazerReserva(Reserva reserva) {
        if (reserva == null) {
            return;
        }
        if (!reservas.contains(reserva)) {
            reservas.add(reserva);
        }
        if (reserva.getUsuario() != this) {
            reserva.setUsuario(this);
        }
    }

    public List<Emprestimo> consultarEmprestimos() {
        return Collections.unmodifiableList(emprestimos);
    }

    public List<Reserva> consultarReservas() {
        return Collections.unmodifiableList(reservas);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo == null) {
            return;
        }
        if (!emprestimos.contains(emprestimo)) {
            emprestimos.add(emprestimo);
        }
        if (emprestimo.getUsuario() != this) {
            emprestimo.setUsuario(this);
        }
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
