import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Autor {
    private Long id;
    private String nome;
    private String nacionalidade;
    private Date dataNascimento;
    private String biografia;

    private final List<Livro> livros = new ArrayList<>();

    public Autor(Long id, String nome, String nacionalidade, Date dataNascimento, String biografia) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.biografia = biografia;
    }

    public List<Livro> consultarObras() {
        return Collections.unmodifiableList(livros);
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            return;
        }
        if (!livros.contains(livro)) {
            livros.add(livro);
        }
        if (!livro.getAutores().contains(this)) {
            livro.adicionarAutor(this);
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
