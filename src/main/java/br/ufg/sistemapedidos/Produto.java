package br.ufg.sistemapedidos;
public class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;
    protected String id;
    protected String descricao;

    // CONTRUTOR

    public Produto(String id, String nome, double preco, String descricao, int estoque){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.estoque += quantidade;
        }
    }

    // GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }

    public String getId(){
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }
}
