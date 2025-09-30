package Pratica;

public class ClientePF extends Cliente {
    private String cpf;

    // CONTRUTOR

    public ClientePF(String nome, String email, String cpf){
        super(nome, email); // CHAMANDO O CONSTRUTOR DA CLASSE MAE
        this.cpf =  cpf;
    }

    // sem métodos

    // GETTERS AND SETTERS 
}
