import java.util.Date;

public class Reserva {
    private Long id;
    private Date dataSolicitacao;
    private Date dataExpiracao;
    private String status;

    private Usuario usuario;
    private Livro livro;

    public Reserva(Long id, Date dataSolicitacao, Date dataExpiracao, String status, Livro livro) {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.dataExpiracao = dataExpiracao;
        this.status = status;
        this.livro = livro;
    }

    public void cancelar() {
        this.status = "CANCELADA";
    }

    public void confirmar() {
        this.status = "CONFIRMADA";
    }

    public boolean verificarExpiracao(Date dataAtual) {
        if (dataExpiracao == null || dataAtual == null) {
            return false;
        }
        return dataAtual.after(dataExpiracao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
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
            usuario.fazerReserva(this);
        }
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
