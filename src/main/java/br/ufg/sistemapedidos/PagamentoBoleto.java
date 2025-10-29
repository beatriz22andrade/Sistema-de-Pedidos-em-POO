package br.ufg.sistemapedidos;

import java.time.LocalDate;

public class PagamentoBoleto implements IPagamento{
    private String codigoBarras;
    private LocalDate dataVencimento;
    private double valor;
    private StatusPagamento statusPagamento;
    
    // CONSTRUTOR

    public PagamentoBoleto(String codigoBarras, double valor, LocalDate dataVencimento) {
        this.codigoBarras = codigoBarras;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    // MÉTODOS

    public boolean processarPagamento(double valor){
        if(valor < 1000.0){
            //System.out.println("Pagamento APROVADO.");
            this.statusPagamento = StatusPagamento.APROVADO;
            return true;
        }else{
            //System.out.println("Pagamento NEGADO.");
            this.statusPagamento = StatusPagamento.RECUSADO;
            return false;
        }
    }

    public StatusPagamento getStatus(){
        return this.statusPagamento;
    }
}
