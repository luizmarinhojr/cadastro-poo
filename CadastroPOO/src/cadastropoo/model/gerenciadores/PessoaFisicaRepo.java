/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model.gerenciadores;

import cadastropoo.model.entidades.PessoaFisica;
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
public class PessoaFisicaRepo {
    
    private List<PessoaFisica> pessoasFisicas;
    
    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList();
    }
    
    public void inserir(PessoaFisica pessoaFisica) {
        if (this.pessoasFisicas.stream().anyMatch((pessoa) -> pessoa.getId() == pessoaFisica.getId())) {
            System.out.println("\n**** A pessoa física %s não foi inserida, pois o ID %d a que ela se refere já se encontra inserido no Array. ****"
                    .formatted(pessoaFisica.getNome(), pessoaFisica.getId()));
        } else {
            this.pessoasFisicas.add(pessoaFisica);
            System.out.println("\n**** Pessoa Física inserida com sucesso ****");
        }  
    }
    
    public void alterar(PessoaFisica pessoaFisicaAtual, PessoaFisica pessoaFisicaNova) {
        pessoaFisicaAtual.setId(pessoaFisicaNova.getId());
        pessoaFisicaAtual.setNome(pessoaFisicaNova.getNome());
        pessoaFisicaAtual.setCpf(pessoaFisicaNova.getCpf());
        pessoaFisicaAtual.setIdade(pessoaFisicaNova.getIdade());
    }
    
    public void excluir(PessoaFisica pessoaFisica) {
        pessoasFisicas.remove(pessoaFisica);
        System.out.println("\n**** Pessoa Física excluída com sucesso ****");
    }
    
    public Optional<PessoaFisica> obter(int id) {
        return pessoasFisicas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst();
    }

    public String obterTodos() {
        this.pessoasFisicas.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
        String pessoasFisicas = "\n-------------------------------------";
        if (!this.pessoasFisicas.isEmpty()) {
            for (PessoaFisica pessoaFisica: this.pessoasFisicas) {
                pessoasFisicas += "\n" + pessoaFisica.exibir() + "-------------------------------------";
            }
        } else {
            pessoasFisicas += "\n" + "Não há pessoas físicas inseridas\n-------------------------------------";
        }
        
        return pessoasFisicas;
    }
    
    public String persistir(String prefixo) throws Exception {
        String nomeArquivo = prefixo + ".fisica.bin";
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.pessoasFisicas);
        this.pessoasFisicas.clear();
        System.out.println("**** Dados de Pessoa Física Armazenados ****");
        return nomeArquivo;
    }
    
    public void recuperar(String prefixo) throws Exception {
        String nomeArquivo = prefixo + ".fisica.bin";
        if (new File(nomeArquivo).exists()) { // Verifica se o arquivo existe no diretório
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.pessoasFisicas = (List<PessoaFisica>) ois.readObject();
            System.out.println("**** Dados de Pessoa Física Recuperados ****");
        } else {
            System.out.println("ATENÇÃO: Dados não recuperados, pois não existe arquivo persistido com o prefixo " + prefixo);
        }
    }
}