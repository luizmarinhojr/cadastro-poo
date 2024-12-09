/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import cadastropoo.model.entidades.PessoaFisica;
import cadastropoo.model.entidades.PessoaJuridica;
import cadastropoo.model.gerenciadores.PessoaFisicaRepo;
import cadastropoo.model.gerenciadores.PessoaJuridicaRepo;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author monster
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    
    static Scanner leitor = new Scanner(System.in);
    
    static PessoaFisicaRepo fisicaRepo = new PessoaFisicaRepo();
    
    static PessoaJuridicaRepo juridicaRepo = new PessoaJuridicaRepo();
    
    public static void main(String[] args) {
        
        Integer escolhaMenu = -1;
        
        String opcoes = """
                        
        =======================================
        1 - Incluir Pessoa
        2 - Alterar Pessoa
        3 - Excluir pessoa
        4 - Buscar pelo Id
        5 - Exibir Todos
        6 - Persistir Dados
        7 - Recuperar Dados
        0 - Finalizar Programa
        =======================================""";
        
        do {
            boolean escolhaValida = false;
            System.out.println(opcoes);
            System.out.print("Digite o número da opção -> ");
            do {
                try {
                    escolhaMenu = Integer.parseInt(leitor.nextLine());
                    escolhaValida = true;
                } catch(NumberFormatException ex) {
                    System.out.println("\nEntrada inválida, tente novamente");
                }
            } while (!escolhaValida);

            switch (escolhaMenu) {
                case 1 -> incluirPessoa();
                    
                case 2 -> alterarPessoa();
                    
                case 3 -> excluirPessoa();
                    
                case 4 -> buscarPeloId();
                    
                case 5 -> exibirTodos();
                    
                case 6 -> persistirDados();
                    
                case 7 -> recuperarDados();
                    
                case 0 -> System.out.println("\nFinalizando o programa...");
                
                default -> System.out.println("\nOpção inválida! Tente novamente.");
                    
            }
                    
        } while (escolhaMenu != 0);
    }
    
    private static void incluirPessoa() {
        switch(selecionarTipoPessoa().toUpperCase()) {
            case "F" -> incluirPessoaFisica();
            
            case "J" -> incluirPessoaJuridica();
        }
    }
    
    private static void alterarPessoa() {
        switch(selecionarTipoPessoa().toUpperCase()) {
            case "F" -> alterarPessoaFisica();
                
            case "J" -> alterarPessoaJuridica();
        }
    }
    
    private static void excluirPessoa() {
         switch(selecionarTipoPessoa().toUpperCase()) {
            case "F" -> excluirPessoaFisica();
            
            case "J" -> excluirPessoaJuridica();
        }
    }

    private static void buscarPeloId() {
         switch(selecionarTipoPessoa().toUpperCase()) {
            case "F" -> buscarPessoaFisicaPeloId();
            
            case "J" -> buscarPessoaJuridicaPeloId();
        }
    }
    
    private static void exibirTodos() {
        switch(selecionarTipoPessoa().toUpperCase()) {
            case "F" -> System.out.println("\n**** Todas as pessoas físicas ****\n" + fisicaRepo.obterTodos());
            
            case "J" -> System.out.println("\n**** Todas as pessoas jurídicas ****\n" + juridicaRepo.obterTodos());
        }
    }
    
    private static void persistirDados() {
        switch(selecionarTipoPessoa().toUpperCase()) {
            case "F" -> persistirPessoaFisica();
                
            case "J" -> persistirPessoaJuridica();
        }
    }
    
    private static void recuperarDados() {
        switch(selecionarTipoPessoa().toUpperCase()) {
            case "F" -> recuperarPessoaFisica();
                
            case "J" -> recuperarPessoaJuridica();
        }
    }
    
    
    // INÍCIO FUNÇÕES AUXILIARES
    
    private static String selecionarTipoPessoa() {
        String escolhaMenu = "";
        
        do {
            System.out.println("\nF - Pessoa física   |   J - Pessoa Jurídica");
            System.out.print("Digite a letra da opção desejada -> ");
            escolhaMenu = leitor.nextLine();
            
        } while(!(escolhaMenu.equalsIgnoreCase("F") || escolhaMenu.equalsIgnoreCase("J")));
        
         return escolhaMenu;
    }
    
    private static Integer digitarIdPessoa(String tipoPessoa) {
        boolean escolhaValida = false;
        Integer idPessoa = -1;
        do {
            try {
                System.out.print("\nDigite o ID da pessoa " + tipoPessoa + " -> ");
                idPessoa = Integer.parseInt(leitor.nextLine());
                escolhaValida = true;
            } catch(NumberFormatException ex) {
                System.out.println("Entrada inválida, tente novamente");
            }
        } while(!escolhaValida);
        
        return idPessoa;
    }
    
    private static Integer digitarIdadePessoa() {
        boolean escolhaValida = false;
        Integer idadePessoa = -1;
        do {
            try {
                System.out.print("\nIdade -> ");
                idadePessoa = Integer.parseInt(leitor.nextLine());
                escolhaValida = true;
            } catch(NumberFormatException ex) {
                System.out.println("Entrada inválida, tente novamente");
            }
        } while(!escolhaValida);
        
        return idadePessoa;
    }
    
    private static void incluirPessoaFisica() {
        Integer idPessoa = digitarIdPessoa("física");
        
        System.out.println("\nInsira os dados...");
        System.out.print("\nNome -> ");
        String nomePessoa = leitor.nextLine();
        
        System.out.print("\nCPF (Somente números) -> ");
        String cpfPessoa = leitor.nextLine();
        
        Integer idadePessoa = digitarIdadePessoa();
        
        fisicaRepo.inserir(new PessoaFisica(idPessoa, nomePessoa, cpfPessoa, idadePessoa));
    }
    
    private static void incluirPessoaJuridica() {
        Integer idPessoa = digitarIdPessoa("jurídica");

        System.out.println("\nInsira os dados...");
        System.out.print("\nNome -> ");
        String nomePessoa = leitor.nextLine();

        System.out.print("\nCNPJ (Somente números) -> ");
        String cnpjPessoa = leitor.nextLine();

        juridicaRepo.inserir(new PessoaJuridica(idPessoa, nomePessoa, cnpjPessoa));
    }
    
    private static void alterarPessoaFisica() {
        String escolhaMenu = "";
        Optional<PessoaFisica> pessoaFisica = buscarPessoaFisicaPeloId();
        
        if (pessoaFisica.isPresent()) {
            do {
                System.out.println("Deseja alterar essa pessoa física? (S) Sim | (N) Não ");
                System.out.print("\nDigite a letra da opção desejada -> ");
                escolhaMenu = leitor.nextLine();
            } while(!(escolhaMenu.equalsIgnoreCase("S") || escolhaMenu.equalsIgnoreCase("N")));
            
            switch (escolhaMenu.toUpperCase()) {
                case "S" -> { 
                    System.out.println("\nInsira os novos dados...");
                    Integer idPessoa = digitarIdPessoa("física");
                    System.out.print("\nNome -> ");
                    String nomePessoa = leitor.nextLine();
                    System.out.print("\nCPF (Somente números) -> ");
                    String cpfPessoa = leitor.nextLine();
                    Integer idadePessoa = digitarIdadePessoa();
                    fisicaRepo.alterar(pessoaFisica.get(), idPessoa, nomePessoa, cpfPessoa, idadePessoa);
                }
                    
                case "N" -> System.out.println("\nPessoa física não alterada. Voltando para o menu...");
            }
        }
        
    }
    
    private static void alterarPessoaJuridica() {
        String escolhaMenu = "";
        Optional<PessoaJuridica> pessoaJuridica = buscarPessoaJuridicaPeloId();
        
        if (pessoaJuridica.isPresent()) {
            do {
                System.out.println("Deseja alterar essa pessoa jurídica? (S) Sim | (N) Não ");
                System.out.print("Digite a letra da opção desejada -> ");
                escolhaMenu = leitor.nextLine();
            } while(!(escolhaMenu.equalsIgnoreCase("S") || escolhaMenu.equalsIgnoreCase("N")));
            
            switch (escolhaMenu.toUpperCase()) {
                case "S" -> { 
                    System.out.println("\nInsira os novos dados...");
                    Integer idPessoa = digitarIdPessoa("jurídica");
                    System.out.print("\nNome -> ");
                    String nomePessoa = leitor.nextLine();
                    System.out.print("\nCNPJ (Somente números) -> ");
                    String cnpjPessoa = leitor.nextLine();
                    juridicaRepo.alterar(pessoaJuridica.get(), idPessoa, nomePessoa, cnpjPessoa);
                }
                
                case "N" -> System.out.println("\nPessoa física não alterada. Voltando para o menu...");
            }
        }
    }
    
    private static void excluirPessoaFisica() {
        String escolhaMenu = "";
        Optional<PessoaFisica> pessoaFisica = buscarPessoaFisicaPeloId();
        if (pessoaFisica.isPresent()) {
            do {
                System.out.println("Deseja excluir essa pessoa física do registro? (S) Sim | (N) Não ");
                System.out.print("Digite a letra da opção desejada -> ");
                escolhaMenu = leitor.nextLine();
            } while(!(escolhaMenu.equalsIgnoreCase("S") || escolhaMenu.equalsIgnoreCase("N")));
            
            switch (escolhaMenu.toUpperCase()) {
                case "S" -> fisicaRepo.excluir(pessoaFisica.get());
                    
                case "N" -> System.out.println("\nPessoa física não excluída. Voltando para o menu...");
            }
        } else {
            System.out.println("\nNão existe pessoa física cadastrada com esse ID");
        }
    }
    
    private static void excluirPessoaJuridica() {
        String escolhaMenu = "";
        Optional<PessoaJuridica> pessoaJuridica = buscarPessoaJuridicaPeloId();
        if (pessoaJuridica.isPresent()) {
            do {
                System.out.println("Deseja excluir essa pessoa jurídica do registro? (S) Sim | (N) Não ");
                System.out.print("Digite a letra da opção desejada -> ");
                escolhaMenu = leitor.nextLine();
            } while(!(escolhaMenu.equalsIgnoreCase("S") || escolhaMenu.equalsIgnoreCase("N")));
            
            switch (escolhaMenu.toUpperCase()) {
                case "S" -> juridicaRepo.excluir(pessoaJuridica.get());
                    
                case "N" -> System.out.println("\nPessoa jurídica não excluída. Voltando para o menu...");
            }
        } else {
            System.out.println("\nNão existe pessoa jurídica cadastrada com esse ID");
        }
    }
    
    private static Optional<PessoaFisica> buscarPessoaFisicaPeloId() {
        Integer idPessoa = digitarIdPessoa("física");
        Optional<PessoaFisica> pessoaFisica = fisicaRepo.obter(idPessoa);
        if (pessoaFisica.isPresent()) {
            System.out.println("\n**** Pessoa física ****\n" + pessoaFisica.get().exibir());
            return pessoaFisica;
        }
        System.out.println("\nNão existe pessoa física cadastrada com esse ID");
        return pessoaFisica;
    }
    
    private static Optional<PessoaJuridica> buscarPessoaJuridicaPeloId() {
        Integer idPessoa = digitarIdPessoa("jurídica");
        Optional<PessoaJuridica> pessoaJuridica = juridicaRepo.obter(idPessoa);
        if (pessoaJuridica.isPresent()) {
            System.out.println("\n**** Pessoa jurídica ****\n" + pessoaJuridica.get().exibir());
            return pessoaJuridica;
        }
        System.out.println("\nNão existe pessoa física cadastrada com esse ID");
        return pessoaJuridica;
    }
    
    private static void persistirPessoaFisica() {
        System.out.print("\nDigite o prefixo do nome do arquivo -> ");
        String prefixo = leitor.nextLine();
        try {
            System.out.println();
            String nomeArquivo = fisicaRepo.persistir(prefixo);
            System.out.println("\nO nome do arquivo persistido é -> " + nomeArquivo);
        } catch(Exception ex) {
            System.out.println("\nHouve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
    }
    
    private static void persistirPessoaJuridica() {
        System.out.print("\nDigite o prefixo do nome do arquivo -> ");
        String prefixo = leitor.nextLine();
        try {
            System.out.println();
            String nomeArquivo = juridicaRepo.persistir(prefixo);
            System.out.println("\nO nome do arquivo persistido é -> " + nomeArquivo);
        } catch(Exception ex) {
            System.out.println("\nHouve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
    }
    
    private static void recuperarPessoaFisica() {
        System.out.print("\nDigite o prefixo do nome do arquivo -> ");
        String prefixo = leitor.nextLine();
        try {
            System.out.println();
            fisicaRepo.recuperar(prefixo);
        } catch(Exception ex) {
            System.out.println("\nHouve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
    }
    
    private static void recuperarPessoaJuridica() {
        System.out.print("\nDigite o prefixo do nome do arquivo -> ");
        String prefixo = leitor.nextLine();
        try {
            System.out.println();
            juridicaRepo.recuperar(prefixo);
        } catch(Exception ex) {
            System.out.println("\nHouve um erro ao armazenar os dados.\n" + "Erro: " + ex.getMessage());
        }
    }
}
