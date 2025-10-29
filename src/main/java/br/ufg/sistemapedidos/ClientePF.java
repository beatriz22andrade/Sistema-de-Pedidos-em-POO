package br.ufg.sistemapedidos;
import java.time.LocalDate;

public class ClientePF extends Cliente {
    private String cpf;
    private LocalDate dataNascimento;

    // CONTRUTOR

    public ClientePF(String nome, String email, String cpf, String id, String telefone, LocalDate dataNascimento){
        super(nome, email, id, telefone); // CHAMANDO O CONSTRUTOR DA CLASSE MAE
        this.cpf =  cpf;
        this.dataNascimento = dataNascimento;
    }

    // GETTERS AND SETTERS 

    public String getIdentificadorUnico() {
        return this.cpf;
    }

    public String getCPF(){
        return this.cpf;
    }
}
