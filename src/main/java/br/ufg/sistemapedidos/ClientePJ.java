package br.ufg.sistemapedidos;
public class ClientePJ extends Cliente {
    private String cnpj; 
    private String razaoSocial;
    private String inscricaoEstadual;

    // CONSTRUTOR 

    public ClientePJ(String id, String nome, String email, String telefone, String cnpj, String razaoSocial) {
        super(id, nome, email, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getIdentificadorUnico() {
        return this.cnpj;
    }

    public String getCNPJ(){
        return this.cnpj;
    }
}
