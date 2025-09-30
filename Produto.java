package Pratica;

public class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;

    // CONTRUTOR

    public  Produto(String nome, double preco, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }
}
