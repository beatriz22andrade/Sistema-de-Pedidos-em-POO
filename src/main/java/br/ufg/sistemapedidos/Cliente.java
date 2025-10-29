package br.ufg.sistemapedidos;
// CLASSE ABSTRATA 

public abstract class Cliente {
    protected String nome;
    protected String email;
    protected String id;
    protected String telefone;

    // CONTRUTOR

    public Cliente(String nome, String email, String id, String telefone){
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.telefone = telefone;
    }

    // MÉTODOS

    public String getId(){
        return this.id;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public abstract String getIdentificadorUnico(); // metodo abstrato
}
