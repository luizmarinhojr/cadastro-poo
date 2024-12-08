/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model.gerenciadores;

import cadastropoo.model.entidades.PessoaJuridica;
import java.io.File;
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
            if (this.pessoasJuridicas.stream().anyMatch((pessoa) -> pessoa.getId() == pessoaJuridica.getId())) {
                System.out.println("A pessoa jurídica %s não foi inserida, pois o ID %d a que ela se refere já se encontra inserido no Array."
                                    .formatted(pessoaJuridica.getNome(), pessoaJuridica.getId()));
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
        this.pessoasJuridicas.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
        String pessoasJuridicas = "";
        for (PessoaJuridica pessoa: this.pessoasJuridicas) {
            pessoasJuridicas += pessoa.exibir();
        }
        return pessoasJuridicas;
    }
    
    public void persistir(String nomeArquivo) throws Exception {
        recuperar(nomeArquivo);
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.pessoasJuridicas);
        System.out.println("Dados de Pessoa Jurídica Armazenados.");
    }
    
    public void recuperar(String nomeArquivo) throws Exception {
        if (new File(nomeArquivo).exists()) {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<PessoaJuridica> dadosRecuperados = (List<PessoaJuridica>) ois.readObject();
            dadosRecuperados.forEach((dado) -> inserir(dado));
            System.out.println("Dados de Pessoa Jurídica Recuperados.");
        }
    }

}