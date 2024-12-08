/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import cadastropoo.model.entidades.PessoaFisica;
import cadastropoo.model.entidades.PessoaJuridica;
import cadastropoo.model.gerenciadores.PessoaFisicaRepo;
import cadastropoo.model.gerenciadores.PessoaJuridicaRepo;

/**
 *
 * @author monster
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // PESSOAS FÍSICAS ABAIXO
        
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        
        PessoaFisica pessoaFisica1 = new PessoaFisica(
                1, "Ana", "11111111111", 25
        );
        
        PessoaFisica pessoaFisica2 = new PessoaFisica(
                2, "Carlos", "22222222222", 52
        );
        
        repo1.inserir(pessoaFisica1, pessoaFisica2);

        try {
            repo1.persistir("PessoasFisicas.bin");
        } catch (Exception ex) {
            System.out.println("Houve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        
        try {
            repo2.recuperar("PessoasFisicas.bin");
        } catch(Exception ex) {
            System.out.println("Houve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
        
        System.out.println(repo2.obterTodos());
        
        
        // PESSOAS JURÍDICAS ABAIXO
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(
                3, "XPTO Sales", "33333333333333"
        );
        
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(
                4, "XPTO Solutions", "44444444444444"
        );
        
        repo3.inserir(pessoaJuridica1, pessoaJuridica2);
        
        try {
            repo3.persistir("PessoasJuridicas.bin");
        } catch (Exception ex) {
            System.out.println("Houve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        
        try {
            repo4.recuperar("PessoasJuridicas.bin");
        } catch(Exception ex) {
            System.out.println("Houve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
        
        System.out.println(repo4.obterTodos());
        
    }
}
