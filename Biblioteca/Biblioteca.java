import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;

    private final List<Exemplar> exemplares = new ArrayList<>();

    public Biblioteca(Long id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void cadastrarExemplar(Exemplar exemplar) {
        if (exemplar == null) {
            return;
        }
        if (!exemplares.contains(exemplar)) {
            exemplares.add(exemplar);
        }
        if (exemplar.getBiblioteca() != this) {
            exemplar.setBiblioteca(this);
        }
    }

    public List<Exemplar> consultarDisponibilidade() {
        return Collections.unmodifiableList(exemplares);
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
