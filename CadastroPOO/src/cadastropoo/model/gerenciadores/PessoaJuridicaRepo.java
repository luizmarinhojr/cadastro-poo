/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model.gerenciadores;

import cadastropoo.model.entidades.PessoaJuridica;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author monster
 */
public class PessoaJuridicaRepo {
    
    private List<PessoaJuridica> pessoasJuridicas;
    
    public PessoaJuridicaRepo() {
        pessoasJuridicas = new ArrayList();
    }
    
    public void inserir(PessoaJuridica... pessoasJuridicas) {
        for (PessoaJuridica pessoaJuridica: pessoasJuridicas) {
            Optional<PessoaJuridica> temPessoaJuridica = this.pessoasJuridicas.stream()
                    .filter(pessoa -> pessoa.getId() == pessoaJuridica.getId()) // Verifica se o ID já se encontra inserido no Array
                    .findFirst();
            if (temPessoaJuridica.isPresent()) {
                System.out.println("A pessoa jurídica " + pessoaJuridica.getNome() + 
                        " não foi inserida, pois o ID " + pessoaJuridica.getId() +
                        " a que ela se refere já se encontra inserido no Array.");
            } else {
                this.pessoasJuridicas.add(pessoaJuridica);
            }
        }
    }
    
    public void alterar(List<PessoaJuridica> pessoasJuridicas) {
        this.pessoasJuridicas = pessoasJuridicas;
    }
    
    public void excluir(PessoaJuridica pessoaJuridica) {
        this.pessoasJuridicas.remove(pessoaJuridica);
    }
    
    public Optional<PessoaJuridica> obter(int id) {
        return pessoasJuridicas.stream()
                .filter(pessoas -> pessoas.getId() == id)
                .findFirst();
    }
    
    public String obterTodos() {
        String pessoasJuridicas = "";
        for (PessoaJuridica pessoa: this.pessoasJuridicas) {
            pessoasJuridicas += pessoa.exibir();
        }
        return pessoasJuridicas;
    }
    
    public void persistir(String nomeArquivo) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.pessoasJuridicas);
        System.out.println("Dados de Pessoa Jurídica Armazenados.");
    }
    
    public void recuperar(String nomeArquivo) throws Exception {
        FileInputStream fis = new FileInputStream(nomeArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.pessoasJuridicas = (List<PessoaJuridica>) ois.readObject();
        System.out.println("Dados de Pessoa Jurídica Recuperados.");
    }

}
