import java.util.Date;

public abstract class Pagamento {
    protected Long id;
    protected Double valor;
    protected Date dataPagamento;
    protected String status;

    public Pagamento(Long id, Double valor, Date dataPagamento, String status) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }

    public abstract void processar();

    public abstract boolean validar();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
