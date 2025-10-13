package Pratica;

public class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;
    protected String id;
    protected String descricao;

    // CONTRUTOR

    public Produto(String nome, double preco, int estoque, String id){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.id = id;
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
