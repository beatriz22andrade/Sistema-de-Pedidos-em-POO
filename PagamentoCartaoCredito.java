package Pratica;

public class PagamentoCartaoCredito implements IPagamento {
    private String numeroCartao;

    // CONTRUTOR

    public PagamentoCartaoCredito(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }

    // MÉTODO EXIGIDO PELA INTERFACE 

    public boolean processarPagamento(double valor){
        if(valor < 200.0){
            System.out.println("Pagamento APROVADO.");
            return true;
        } else {
            System.out.println("Pagamento NEGADO.");
            return false;
        }
    }
}
