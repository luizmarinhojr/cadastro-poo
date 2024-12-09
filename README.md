# Cadastro utilizando Programação Orientada a Objetos com persistência de dados em arquivos binários

- Essa missão prática foi dividida em dois procedimentos. 
- O 1ª Procedimento envolve a Criação das Entidades e Sistema de Persistência, enquanto que o 2ª Procedimento envolve a Criação do Cadastro em Modo Texto. O desenvolvimento dos procedimentos estão organizados por branch. 
- O 1ª Procedimento está na branch PrimeiroProcedimento, e o 2ª Procedimento está na branch SegundoProcedimento.
- Essa branch **main** se refere a um resumo dos dois procedimentos. Para visualizar as informações mais detalhadas, mude para a branch do procedimento desejado.

## Objetivos da prática
1. Utilizar herança e polimorfismo na  definição de entidades.
2. Utilizar persistência de objetos em arquivos binários.
3. Implementar uma interface cadastral em modo texto.
4. Utilizar o controle de exceções da plataforma Java.
5. Implementar um sistema cadastral em Java,
utilizando os recursos da programação orientada a objetos e a persistência em
arquivos binários.

## Tecnologias utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

## Diagrama de classes
```mermaid
---
title: Cadastro POO
---

classDiagram
    direction TB
    class Pessoa
    class PessoaFisica
    class PessoaJuridica
    class PessoaFisicaRepo
    class PessoaJuridicaRepo
    
    PessoaFisicaRepo --> PessoaFisica
    PessoaJuridicaRepo --> PessoaJuridica
    Pessoa <|-- PessoaFisica
    Pessoa <|-- PessoaJuridica
    
    
    <<Abstract>> Pessoa
    Pessoa : -int id
    Pessoa : -String nome
    Pessoa : +exibir()* String
    
    PessoaFisica : -String cpf
    PessoaFisica : -int idade
    PessoaFisica : +exibir() String
    
    PessoaJuridica : -String cnpj
    PessoaJuridica : +exibir() String
    
    PessoaFisicaRepo : -List<PessoaFisica> pessoasFisicas
    PessoaFisicaRepo : +inserir(pessoaFisica) void
    PessoaFisicaRepo : +alterar(pessoaFisicaAtual, pessoaFisicaNova) void
    PessoaFisicaRepo : +excluir(pessoaFisica) void
    PessoaFisicaRepo : +obter(id) Optional~PessoaJuridica~
    PessoaFisicaRepo : +obterTodos() String
    PessoaFisicaRepo : +persistir(prefixo) String
    PessoaFisicaRepo : +recuperar(prefixo) void
    
    PessoaJuridicaRepo : -List<PessoaJuridica> pessoasFisicas
    PessoaJuridicaRepo : +inserir(pessoaJuridica) void
    PessoaJuridicaRepo : +alterar(pessoaJuridicaAtual, pessoaJuridicaNova) void
    PessoaJuridicaRepo : +excluir(pessoaJuridica) void
    PessoaJuridicaRepo : +obter(id) Optional~PessoaJuridica~
    PessoaJuridicaRepo : +obterTodos() String
    PessoaJuridicaRepo : +persistir(prefixo) String
    PessoaJuridicaRepo : +recuperar(prefixo) void
```
