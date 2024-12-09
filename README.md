# 1ª Procedimento
## Criação das Entidades e Sistema de Persistência
❕Essa branch se refere somente ao 1ª Procedimento.

## Objetivos desse procedimento
1. Utilizar herança e polimorfismo na  definição de entidades.
2. Utilizar persistência de objetos em arquivos binários.
3. Utilizar o controle de exceções da plataforma Java.

## Tecnologias utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

## Diagrama das classes
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
    PessoaFisicaRepo : +alterar(pessoaFisica) void
    PessoaFisicaRepo : +excluir(pessoaFisica) void
    PessoaFisicaRepo : +obter(id) Optional~PessoaJuridica~
    PessoaFisicaRepo : +obterTodos() String
    PessoaFisicaRepo : +persistir(prefixo) void
    PessoaFisicaRepo : +recuperar(prefixo) void
    
    PessoaJuridicaRepo : -List<PessoaJuridica> pessoasFisicas
    PessoaJuridicaRepo : +inserir(pessoaJuridica) void
    PessoaJuridicaRepo : +alterar(pessoaJuridica) void
    PessoaJuridicaRepo : +excluir(pessoaJuridica) void
    PessoaJuridicaRepo : +obter(id) Optional~PessoaJuridica~
    PessoaJuridicaRepo : +obterTodos() String
    PessoaJuridicaRepo : +persistir(prefixo) void
    PessoaJuridicaRepo : +recuperar(prefixo) void
```
