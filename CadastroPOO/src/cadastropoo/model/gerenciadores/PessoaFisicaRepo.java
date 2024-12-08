/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model.gerenciadores;

import cadastropoo.model.entidades.PessoaFisica;
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
    
    public void inserir(PessoaFisica... pessoasFisicas) {
        for (PessoaFisica pessoaFisica: pessoasFisicas) {
            this.pessoasFisicas.add(pessoaFisica);
        }
    }
    
    public void alterar(List<PessoaFisica> pessoasFisicas) {
        this.pessoasFisicas = pessoasFisicas;
    }
    
    public void excluir(PessoaFisica pessoaFisica) {
        pessoasFisicas.remove(pessoaFisica);
    }
    
    public Optional<PessoaFisica> obter(int id) {
        return pessoasFisicas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst();
    }

    public String obterTodos() {
        String pessoasFisicas = "\n";
        for (PessoaFisica pessoaFisica: this.pessoasFisicas) {
            pessoasFisicas += pessoaFisica.exibir();
        }
        return pessoasFisicas;
    }
    
    public void persistir(String nomeArquivo) throws Exception{
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(pessoasFisicas);
        System.out.println("Dados de Pessoa Física Armazenados.");
    }
    
    public void recuperar(String nomeArquivo) throws Exception{
        FileInputStream fis = new FileInputStream(nomeArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        pessoasFisicas = (List<PessoaFisica>) ois.readObject();
        System.out.println("Dados de Pessoa Física Recuperados.");
    }
}
