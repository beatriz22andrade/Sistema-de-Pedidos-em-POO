package Pratica;

public class PagamentoBoleto implements IPagamento{
    private String codigoBarras;

    public PagamentoBoleto(String codigoBarras){
        this.codigoBarras = codigoBarras;
    }

    public boolean processarPagamento(double valor){
        if(valor < 1000.0){
            System.out.println("Pagamento APROVADO.");
            return true;
        }else{
            System.out.println("Pagamento NEGADO.");
            return false;
        }
    }
}
