import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Livro {
    private Long id;
    private String titulo;
    private String isbn;
    private Integer anoPublicacao;
    private String categoria;

    private final List<Autor> autores = new ArrayList<>();
    private Editora editora;

    public Livro(Long id, String titulo, String isbn, Integer anoPublicacao, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
    }

    public String consultarInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: ").append(titulo).append(", ISBN: ").append(isbn);
        return sb.toString();
    }

    public void adicionarAutor(Autor autor) {
        if (autor == null) {
            return;
        }
        if (!autores.contains(autor)) {
            autores.add(autor);
        }
        if (!autor.getLivros().contains(this)) {
            autor.adicionarLivro(this);
        }
    }

    public List<Autor> getAutores() {
        return Collections.unmodifiableList(autores);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
        if (editora != null && !editora.getLivros().contains(this)) {
            editora.adicionarLivro(this);
        }
    }
}
