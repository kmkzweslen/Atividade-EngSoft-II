import java.util.Date;

public class Emprestimo {
    private Long id;
    private Date dataRetirada;
    private Date dataDevolucaoPrevista;
    private Date dataDevolucaoReal;
    private String status;

    private Usuario usuario;
    private Livro livro;
    private Exemplar exemplar;

    public Emprestimo(Long id, Date dataRetirada, Date dataDevolucaoPrevista, String status, Livro livro, Exemplar exemplar) {
        this.id = id;
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.status = status;
        this.livro = livro;
        this.exemplar = exemplar;
    }

    public void registrarRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
        this.status = "EM_ANDAMENTO";
        if (exemplar != null) {
            exemplar.atualizarStatus("EMPRESTADO");
        }
    }

    public void registrarDevolucao(Date dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.status = "DEVOLVIDO";
        if (exemplar != null) {
            exemplar.atualizarStatus("DISPONIVEL");
        }
    }

    public double calcularMulta(double valorPorDia) {
        if (dataDevolucaoPrevista == null || dataDevolucaoReal == null) {
            return 0.0;
        }
        long atrasoMs = dataDevolucaoReal.getTime() - dataDevolucaoPrevista.getTime();
        if (atrasoMs <= 0) {
            return 0.0;
        }
        long dias = atrasoMs / (1000L * 60L * 60L * 24L);
        if (atrasoMs % (1000L * 60L * 60L * 24L) != 0) {
            dias++;
        }
        return dias * valorPorDia;
    }

    public void renovar(Date novaDataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = novaDataDevolucaoPrevista;
        this.status = "RENOVADO";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public Date getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(Date dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null) {
            usuario.adicionarEmprestimo(this);
        }
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
}
