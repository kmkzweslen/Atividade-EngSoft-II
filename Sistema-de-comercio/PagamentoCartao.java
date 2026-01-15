import java.util.Date;

public class PagamentoCartao extends Pagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String validade;
    private String cvv;
    private String bandeira;

    public PagamentoCartao(Long id, Double valor, Date dataPagamento, String status,
                           String numeroCartao, String nomeTitular, String validade,
                           String cvv, String bandeira) {
        super(id, valor, dataPagamento, status);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.cvv = cvv;
        this.bandeira = bandeira;
    }

    @Override
    public void processar() {
        if (validar()) {
            this.status = "APROVADO";
        } else {
            this.status = "RECUSADO";
        }
    }

    @Override
    public boolean validar() {
        return numeroCartao != null && numeroCartao.length() >= 12
                && cvv != null && cvv.length() >= 3;
    }

    public boolean verificarLimite(double limiteDisponivel) {
        if (valor == null) {
            return false;
        }
        return valor <= limiteDisponivel;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
