import java.util.Date;

public class PagamentoPix extends Pagamento {
    private String chavePix;
    private String qrCode;
    private String txId;

    public PagamentoPix(Long id, Double valor, Date dataPagamento, String status,
                        String chavePix, String txId) {
        super(id, valor, dataPagamento, status);
        this.chavePix = chavePix;
        this.txId = txId;
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
        return chavePix != null && !chavePix.isEmpty();
    }

    public String gerarQRCode() {
        this.qrCode = "PIX:" + chavePix + ":" + (txId != null ? txId : "");
        return qrCode;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getQrCode() {
        return qrCode;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }
}
