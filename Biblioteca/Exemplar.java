public class Exemplar {
    private Long id;
    private String codigoExemplar;
    private String estado;
    private boolean disponivel;

    private Biblioteca biblioteca;

    public Exemplar(Long id, String codigoExemplar, String estado, boolean disponivel) {
        this.id = id;
        this.codigoExemplar = codigoExemplar;
        this.estado = estado;
        this.disponivel = disponivel;
    }

    public void atualizarStatus(String novoEstado) {
        this.estado = novoEstado;
        this.disponivel = "DISPONIVEL".equalsIgnoreCase(novoEstado);
    }

    public boolean verificarDisponibilidade() {
        return disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}
