import java.util.Date;

public class PagamentoBoleto extends Pagamento {
    private String codigoBarras;
    private String linhaDigitavel;
    private Date dataVencimento;

    public PagamentoBoleto(Long id, Double valor, Date dataPagamento, String status,
                           String codigoBarras, String linhaDigitavel, Date dataVencimento) {
        super(id, valor, dataPagamento, status);
        this.codigoBarras = codigoBarras;
        this.linhaDigitavel = linhaDigitavel;
        this.dataVencimento = dataVencimento;
    }

    @Override
    public void processar() {
        if (validar()) {
            this.status = "PROCESSANDO";
        } else {
            this.status = "RECUSADO";
        }
    }

    @Override
    public boolean validar() {
        return codigoBarras != null && !codigoBarras.isEmpty();
    }

    public String gerarBoleto() {
        if (codigoBarras == null || codigoBarras.isEmpty()) {
            codigoBarras = "00000000000000000000000000000000000000000000";
        }
        if (linhaDigitavel == null || linhaDigitavel.isEmpty()) {
            linhaDigitavel = codigoBarras;
        }
        return linhaDigitavel;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
