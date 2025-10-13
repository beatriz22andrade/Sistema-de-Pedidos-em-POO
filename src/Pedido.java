package Pratica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pedido{
    private LocalDate data;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private IPagamento metodoPagamento;
    private StatusPedido statusPedido;

    // CONTRUTOR

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.statusPedido = StatusPedido.PENDENTE;
        this.itens = new ArrayList<>();
    }

    // METODOS  

    public void adicionarItem(Produto produto, int quantidade) {
        Optional<ItemPedido> itemExistente = this.itens.stream()
            .filter(item -> item.getProduto().getId().equals(produto.getId()))
            .findFirst();

        if (itemExistente.isPresent()) {
            itemExistente.get().adicionarQuantidade(quantidade);
        } else {
            this.itens.add(new ItemPedido(produto, quantidade));
        }
    }

    public void removerItem(Produto produto) {
        this.itens.removeIf(item -> item.getProduto().getId().equals(produto.getId()));
    }

    public double aplicarDesconto(double percentualDesconto) {
        double total = this.calcularTotal();
        if (percentualDesconto > 0 && percentualDesconto < 1) { 
            return total * (1 - percentualDesconto);
        }
        return total;
    }

    public double calcularTotal(){
        double total = 0.0;
        for (ItemPedido item : this.itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public boolean confirmarPedido() {
        if (metodoPagamento == null) {
            System.out.println("Erro: Nenhum método de pagamento definido.");
            return false;
        }

        boolean pagamentoOk = metodoPagamento.processarPagamento(this.calcularTotal());

        if (pagamentoOk) {
            this.statusPedido = StatusPedido.PROCESSANDO;
            System.out.println("Pedido confirmado! Status alterado para PROCESSANDO.");
        } else {
            this.statusPedido = StatusPedido.CANCELADO;
            System.out.println("Falha no pagamento. Status do pedido alterado para CANCELADO.");
        }
        return pagamentoOk;
    }
    
    // GETTERS AND SETTERS

    public IPagamento getMetodoPagamento(){
        return metodoPagamento;
    }

    public List<ItemPedido> getItens() { 
        return itens; 
    }

    public StatusPedido getStatusPedido() { 
        return statusPedido; 
    }

    public void setMetodoPagamento(IPagamento metodoPagamento) { 
        this.metodoPagamento = metodoPagamento; 
    }

}