package Pratica;

public class ItemPedido {
    private Produto produto;
    private int quantidade;

    // CONSTRUTOR

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // MÉTODOS

    public double getSubtotal(){
        return produto.getPreco() * quantidade;
    }

    // GETTERS AND SETTERS
}
