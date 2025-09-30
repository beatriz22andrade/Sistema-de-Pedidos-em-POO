package Pratica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido{
    private LocalDate data;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private IPagamento metodoPagamento;

    // CONTRUTOR

    public Pedido (LocalDate data, Cliente cliente, IPagamento metodoPagamento){
        this.data = data;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
        this.itens = new ArrayList<>(); //começa vazio como na realidade
    }

    // METODOS  

    public void adicionarItem(Produto produto, int quantidade){
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        this.itens.add(novoItem);
    }

    public double calcularTotal(){
        double total = 0.0;
        for (ItemPedido item : this.itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public IPagamento getMetodoPagamento(){
        return metodoPagamento;
    }

    // GETTERS AND SETTERS

}