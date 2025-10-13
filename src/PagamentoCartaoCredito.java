package Pratica;

import java.time.LocalDate;

public class PagamentoCartaoCredito implements IPagamento {
    private String numeroCartao;
    private String nomeTitular;
    private LocalDate dataValidade;
    private StatusPagamento statusPagamento;

    // CONTRUTOR

    public PagamentoCartaoCredito(String numeroCartao, String nomeTitular, LocalDate dataValidade){
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    // MÉTODO EXIGIDO PELA INTERFACE 

    public boolean processarPagamento(double valor) {
        if (valor < 5000.0) {
            System.out.println("Processando Cartão de Crédito... Pagamento APROVADO.");
            this.statusPagamento = StatusPagamento.APROVADO;
            return true;
        } else {
            System.out.println("Processando Cartão de Crédito... Pagamento RECUSADO (Limite excedido).");
            this.statusPagamento = StatusPagamento.RECUSADO;
            return false;
        }
    }

    public StatusPagamento getStatus(){
        return this.statusPagamento;
    }
}
