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
public class PessoaJuridica extends Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    public PessoaJuridica() {}
    
    @Override
    public String exibir() {
        return "Id: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "CNPJ: " + this.cnpj + "\n";
    }
    
    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "\n" + "Id: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "CNPJ: " + getCnpj();
    }
    
    
}
