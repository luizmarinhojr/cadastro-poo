/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model.entidades;

import java.io.Serializable;

/**
 *
 * @author monster
 */
public class PessoaFisica extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cpf;
    private int idade;

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public PessoaFisica() {}
    
    @Override
    public String exibir(){
        return "Id: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Idade: " + getIdade() + "\n";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "\n" + "Id: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Idade: " + getIdade();
    }
    
}
