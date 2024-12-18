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
    
    public void inserir(PessoaJuridica pessoaJuridica) {
        if (this.pessoasJuridicas.stream().anyMatch((pessoa) -> pessoa.getId() == pessoaJuridica.getId())) {
            System.out.println("\n**** A pessoa jurídica %s não foi inserida, pois o ID %d a que ela se refere já se encontra inserido no Array. ****"
                                .formatted(pessoaJuridica.getNome(), pessoaJuridica.getId()));
        } else {
            this.pessoasJuridicas.add(pessoaJuridica);
            System.out.println("\n**** Pessoa Jurídica inserida com sucesso ****");
        }
    }
    
    public void alterar(PessoaJuridica pessoaJuridicaAtual, PessoaJuridica pessoaJuridicaNova) {
        pessoaJuridicaAtual.setId(pessoaJuridicaNova.getId());
        pessoaJuridicaAtual.setNome(pessoaJuridicaNova.getNome());
        pessoaJuridicaAtual.setCnpj(pessoaJuridicaNova.getCnpj());
    }
    
    public void excluir(PessoaJuridica pessoaJuridica) {
        this.pessoasJuridicas.remove(pessoaJuridica);
        System.out.println("\n**** Pessoa Jurídica excluída com sucesso ****");
    }
    
    public Optional<PessoaJuridica> obter(int id) {
        return pessoasJuridicas.stream()
                .filter(pessoas -> pessoas.getId() == id)
                .findFirst();
    }
    
    public String obterTodos() {
        this.pessoasJuridicas.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
        String pessoasJuridicas = "\n-------------------------------------";
        if (!this.pessoasJuridicas.isEmpty()) {
            for (PessoaJuridica pessoa: this.pessoasJuridicas) {
                pessoasJuridicas += "\n" + pessoa.exibir() + "-------------------------------------";
            }
        } else {
            pessoasJuridicas += "\n" + "Não há pessoas jurídicas inseridas\n-------------------------------------";
        }
        
        return pessoasJuridicas;
    }
    
    public String persistir(String prefixo) throws Exception {
        String nomeArquivo = prefixo + ".juridica.bin";
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.pessoasJuridicas);
        this.pessoasJuridicas.clear();
        System.out.println("**** Dados de Pessoa Jurídica Armazenados ****");
        return nomeArquivo;
    }
    
    public void recuperar(String prefixo) throws Exception {
        String nomeArquivo = prefixo + ".juridica.bin";
        if (new File(nomeArquivo).exists()) {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.pessoasJuridicas = (List<PessoaJuridica>) ois.readObject();
            System.out.println("**** Dados de Pessoa Jurídica Recuperados ****");
        } else {
            System.out.println("**** ATENÇÃO: Dados não recuperados, pois não existe arquivo persistido com o prefixo " + prefixo + " ****");
        }
    }

}