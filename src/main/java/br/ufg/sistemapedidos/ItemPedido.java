package br.ufg.sistemapedidos;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    // CONSTRUTOR

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    // MÉTODOS

    public double getSubtotal(){
        return this.quantidade * this.precoUnitario;
    }

    public int adicionarQuantidade(int quantidadeAdicional) {
        if (quantidadeAdicional > 0) {
            this.quantidade += quantidadeAdicional;
        }
        return this.quantidade;
    }

    // GETTERS AND SETTERS

    public Produto getProduto() { 
        return produto; 
    }

    public int getQuantidade() { 
        return quantidade; 
    }
}
