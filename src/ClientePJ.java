package Pratica;

public class ClientePJ extends Cliente {
    private String cnpj; 

    // CONSTRUTOR 

    public ClientePJ(String nome, String email, String cnpj){
        super(nome, email);
        this.cnpj = cnpj;
    }
}
