package br.ufg.sistemapedidos;
public interface IPagamento {
    
    // MÉTODO DA INTERFACE

    boolean processarPagamento(double valor);

    StatusPagamento getStatus();
}
