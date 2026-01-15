import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Editora {
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;

    private final List<Livro> livros = new ArrayList<>();

    public Editora(Long id, String nome, String cnpj, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public List<Livro> consultarPublicacoes() {
        return Collections.unmodifiableList(livros);
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            return;
        }
        if (!livros.contains(livro)) {
            livros.add(livro);
        }
        if (livro.getEditora() != this) {
            livro.setEditora(this);
        }
    }

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
