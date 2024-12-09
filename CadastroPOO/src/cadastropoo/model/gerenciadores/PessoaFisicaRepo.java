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
    
    public void inserir(PessoaFisica... pessoasFisicas) {
        for (PessoaFisica pessoaFisica: pessoasFisicas) {
            if (this.pessoasFisicas.stream().anyMatch((pessoa) -> pessoa.getId() == pessoaFisica.getId())) {
                System.out.println("\n**** A pessoa física %s não foi inserida, pois o ID %d a que ela se refere já se encontra inserido no Array. ****"
                        .formatted(pessoaFisica.getNome(), pessoaFisica.getId()));
            } else {
                this.pessoasFisicas.add(pessoaFisica);
            }  
        }
    }
    
    public void alterar(PessoaFisica pessoaFisica, Integer id, String nome, String cpf, Integer idade) {
        pessoaFisica.setId(id);
        pessoaFisica.setNome(nome);
        pessoaFisica.setCpf(cpf);
        pessoaFisica.setIdade(idade);
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
        this.pessoasFisicas.sort((p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
        String pessoasFisicas = "\n-------------------------------------";
        for (PessoaFisica pessoaFisica: this.pessoasFisicas) {
            pessoasFisicas += "\n" + pessoaFisica.exibir() + "-------------------------------------";
        }
        return pessoasFisicas;
    }
    
    public String persistir(String prefixo) throws Exception {
        String nomeArquivo = prefixo + ".fisica.bin";
        recuperar(prefixo); // Recupera os dados do arquivo 
        FileOutputStream fos = new FileOutputStream(nomeArquivo);
        ObjectOutputStream ous = new ObjectOutputStream(fos);
        ous.writeObject(this.pessoasFisicas);
        System.out.println("Dados de Pessoa Física Armazenados.");
        return nomeArquivo;
    }
    
    public void recuperar(String prefixo) throws Exception {
        String nomeArquivo = prefixo + ".fisica.bin";
        if (new File(nomeArquivo).exists()) { // Verifica se o arquivo existe no diretório
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<PessoaFisica> dadosRecuperados = (List<PessoaFisica>) ois.readObject();
            dadosRecuperados.forEach((dado) -> inserir(dado));
            System.out.println("Dados de Pessoa Física Recuperados.");
        } else {
            System.out.println("ATENÇÃO: Dados não recuperados, pois não existe arquivo persistido com o prefixo " + prefixo);
        }
    }
}